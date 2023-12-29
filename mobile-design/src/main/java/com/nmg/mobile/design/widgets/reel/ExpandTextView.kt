package com.nmg.mobile.design.widgets.reel

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.nmg.mobile.design.theme.NMGTheme

const val DEFAULT_MINIMUM_TEXT_LINE = 2



interface StylableText {
    val text: String
    val style: SpanStyle
    val apply: @Composable (AnnotatedString.Builder) -> Unit
    val action: (() -> Unit)?
}
interface ExpandActionable: StylableText {
    val adjust: @Composable (String, Int) -> String
}

interface CollapseActionable: StylableText {
}

data class DefaultExpandActionable(
    override val text: String,
    override val style: SpanStyle,
    override val adjust: @Composable (String, Int) -> String = { content, lastCharIndex ->
        content.substring(startIndex = 0, endIndex = lastCharIndex)
            .dropLast(text.length)
            .dropLastWhile { charactor ->  Character.isWhitespace(charactor) || charactor == '.' }
    },
    override val apply: @Composable (AnnotatedString.Builder) -> Unit = {
        it.withStyle(style = style) { it.append(text) }
    },
    override val action: (() -> Unit)? = null
): ExpandActionable

data class DefaultCollapseActionable(
    override val text: String,
    override val style: SpanStyle,
    override val apply: @Composable (AnnotatedString.Builder) -> Unit = {
        it.withStyle(style = style) { it.append(text) }
    },
    override val action: (() -> Unit)? = null
): CollapseActionable
interface ExpandTextViewDataProtocol {
    val collapsedMaxLine: Int
    val expandActionable: ExpandActionable
    val collapseActionable: CollapseActionable?
}

data class ExpandTextViewData(
    override val collapsedMaxLine: Int = DEFAULT_MINIMUM_TEXT_LINE,
    override val expandActionable: ExpandActionable,
    override val collapseActionable: CollapseActionable?,
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
    var rememberTextLayoutResult by remember {
        mutableStateOf<androidx.compose.ui.text.TextLayoutResult?>(null)
    }
    val spanStyle = SpanStyle(
        color = textColor,
        fontWeight = FontWeight.W400,
        fontStyle = FontStyle.Normal
    )
    LaunchedEffect(text) {
        isExpanded = false
    }
    Box(
        modifier = Modifier
            .then(modifier)
    ) {
        if (text.isNotEmpty()) {
            ClickableText(
                text = buildAnnotatedString {
                    if (!clickable) {
                        withStyle(style = spanStyle) {
                            append(text)
                        }
                        return@buildAnnotatedString
                    }
                    if (isExpanded) {
                        withStyle(style = spanStyle) {
                            append(text)
                        }
                        data.collapseActionable?.let { actionable ->
                            actionable.apply(this@buildAnnotatedString)
                        }
                    } else {
                        data.expandActionable.apply {
                            val actionable = this
                            append(this.adjust(text, lastCharIndex))
                            actionable.apply(this@buildAnnotatedString)
                        }
                    }

                },
                modifier = textModifier
                    .fillMaxWidth()
                    .animateContentSize(),
                maxLines = if (isExpanded) Int.MAX_VALUE else data.collapsedMaxLine,
                onTextLayout = { textLayoutResult ->
                    rememberTextLayoutResult = textLayoutResult
                    if (!isExpanded && textLayoutResult.hasVisualOverflow) {
                        clickable = true
                        lastCharIndex = textLayoutResult.getLineEnd(data.collapsedMaxLine - 1)
                    }
                },
                style = style,
                onClick = {
                    val actionable = when (isExpanded) {
                        true -> data.expandActionable
                        else -> data.collapseActionable ?: data.expandActionable
                    }
                    val lastCharacter =  rememberTextLayoutResult?.getLineEnd((rememberTextLayoutResult?.lineCount ?: data.collapsedMaxLine) - 1)
                    if (lastCharacter != null) {
                        if (it < (lastCharacter - actionable.text.length)) {
                            return@ClickableText
                        }
                    }
                    when {
                        (!isExpanded && data.collapseActionable == null) -> {
                            clickable = false
                        }
                        (isExpanded && data.collapseActionable == null) -> {
                            return@ClickableText
                        }
                    }

                    isExpanded = !isExpanded

                    when (isExpanded) {
                        true -> { data.expandActionable.action?.invoke() }
                        else -> { data.collapseActionable?.action?.invoke() }
                    }
            })

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
    expandActionable: ExpandActionable = DefaultExpandActionable(
        text = "...展開",
        style = SpanStyle(
            color = textColor,
            fontWeight = FontWeight.W400,
            fontStyle = FontStyle.Normal
        )
    ),
    collapseActionable: CollapseActionable? = DefaultCollapseActionable(
        text = "收起",
        style = SpanStyle(
            color = textColor,
            fontWeight = FontWeight.W400,
            fontStyle = FontStyle.Normal
        )
    )
) {

    NMGTheme {
        ExpandTextView(
            modifier = modifier,
            textModifier = textModifier,
            style = textStyle,
            fontStyle = fontStyle,
            textColor = textColor,
            text = content,
            data = ExpandTextViewData(
                expandActionable = expandActionable,
                collapseActionable = collapseActionable
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