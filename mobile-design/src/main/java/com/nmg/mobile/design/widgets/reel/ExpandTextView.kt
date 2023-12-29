package com.nmg.mobile.design.widgets.reel

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.nmg.mobile.design.theme.NMGTheme

const val DEFAULT_MINIMUM_TEXT_LINE = 2



interface StylableText {
    val text: String
    val style: SpanStyle
}
interface ExpandActionable: StylableText {
    fun onClickExpandible(action: (Boolean) -> Unit)
}

interface CollapseActionable: StylableText {
    fun onClickCollapsible(action: (Boolean) -> Unit)
}

data class DefaultExpandActionable(
    override val text: String,
    override val style: SpanStyle
): ExpandActionable {
    override fun onClickExpandible(action: (Boolean) -> Unit) {
        action(true)
    }
}

data class DefaultCollapseActionable(
    override val text: String,
    override val style: SpanStyle
): CollapseActionable {
    override fun onClickCollapsible(action: (Boolean) -> Unit) {
        action(false)
    }
}

interface ExpandTextViewDataProtocol {
    val collapsedMaxLine: Int
    val expandActionable: ExpandActionable
    val collapseActionable: CollapseActionable?
    val isCollapsible: Boolean
}

data class ExpandTextViewData(
    override val collapsedMaxLine: Int = DEFAULT_MINIMUM_TEXT_LINE,
    override val expandActionable: ExpandActionable,
    override val collapseActionable: CollapseActionable,
    override val isCollapsible: Boolean = true
): ExpandTextViewDataProtocol

@Composable
public fun<Data: ExpandTextViewDataProtocol> ExpandTextView(
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    fontStyle: FontStyle? = null,
    textColor: Color = Color.White,
    text: String,
    textAlign: TextAlign? = null,
    data: Data,
) {
    var isExpanded by remember { mutableStateOf(false) }
    var clickable by remember { mutableStateOf(false) }
    var lastCharIndex by remember { mutableStateOf(0) }
    LaunchedEffect(text) {
        clickable = true
        isExpanded = false
    }
    Box(
        modifier = Modifier
            .clickable(clickable) {
                if (isExpanded && !data.isCollapsible) {
                    clickable = false
                    return@clickable
                }
                isExpanded = !isExpanded
                when (isExpanded) {
                    true -> data.expandActionable.onClickExpandible { isExpanded = it }
                    else -> data.collapseActionable?.onClickCollapsible { isExpanded = it }
                }
            }
            .then(modifier)
    ) {
        if (text.length > 0) {
            Text(
                modifier = textModifier
                    .fillMaxWidth()
                    .animateContentSize(),
                text = buildAnnotatedString {
                    if (clickable) {
                        if (isExpanded) {
                            append(text)
                            data.collapseActionable?.let {
                                withStyle(style = it.style) {
                                    if (data.isCollapsible) {
                                        append(it.text)
                                    }
                                }
                            }
                        } else {
                            data.expandActionable.apply {
                                val action = this
                                val adjustText =
                                    text.substring(startIndex = 0, endIndex = lastCharIndex)
                                        .dropLast(action.text.length)
                                        .dropLastWhile { Character.isWhitespace(it) || it == '.' }
                                append(adjustText)
                                withStyle(style = action.style) { append(action.text) }
                            }
                        }
                    } else {
                        append(text)
                    }
                },
                maxLines = if (isExpanded) Int.MAX_VALUE else data.collapsedMaxLine,
                fontStyle = fontStyle,
                fontSize = 14.sp,
                fontWeight = FontWeight.W400,
                color = textColor,
                onTextLayout = { textLayoutResult ->
                    if (!isExpanded && textLayoutResult.hasVisualOverflow) {
                        clickable = true
                        lastCharIndex = textLayoutResult.getLineEnd(data.collapsedMaxLine - 1)
                    }
                },
                style = style,
                textAlign = textAlign
            )
        }
    }
}

@Composable
public fun DefaultExpandTextView(
    content: String,
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current,
    fontStyle: FontStyle? = null,
    textColor: Color = Color.White,
) {
    val style = SpanStyle(
        color = textColor,
        fontWeight = FontWeight.W400,
        fontStyle = FontStyle.Normal
    )

    NMGTheme {
        ExpandTextView(
            modifier = modifier,
            textModifier = textModifier,
            style = textStyle,
            fontStyle = fontStyle,
            textColor = textColor,
            text = content,
            data = ExpandTextViewData(
                expandActionable = DefaultExpandActionable(
                    text = "...展開",
                    style = style
                ),
                collapseActionable = DefaultCollapseActionable(
                    text = "收起",
                    style = style
                )
            )
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
public fun ExpandTextViewPreview() {
    val content = "若從每人身上賺1元大餅，已是14個億的大茶飯，難度在於中間化零為整的手段。滴灌通主席李小加就想到了破解方案，兼開發出複利生財的投資模式，有如太極生兩儀、兩儀生四象。薑是老的辣，61歲的他下海創業，把生意經的算盤敲得響噹噹。"
    NMGTheme {
        DefaultExpandTextView(content = content)
    }
}