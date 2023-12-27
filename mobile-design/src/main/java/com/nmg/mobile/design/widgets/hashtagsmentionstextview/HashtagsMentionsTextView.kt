package com.nmg.mobile.design.widgets.hashtagsmentionstextview

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.theme.NMGTheme

@Composable
fun HashtagsMentionsTextView(
    text: String,
    modifier: Modifier = Modifier,
    theme: NMGTheme = NMGTheme,
    onClick: (String) -> Unit
) {
    val typography = theme.typography
    val colors = theme.colors
    val textStyle = SpanStyle(color = colors.textSecondary)
    val primaryStyle = SpanStyle(color = colors.primaryMain)

    val hashtags = Regex("((?=[^\\w!])[#@][\\u4e00-\\u9fa5\\w]+)")

    val annotatedStringList = remember {
        var lastIndex = 0
        val annotatedStringList = mutableStateListOf<AnnotatedString.Range<String>>()

        // Add a text range for hashtags
        for (match in hashtags.findAll(text)) {
            val start = match.range.first
            val end = match.range.last + 1
            val string = text.substring(start, end)

            if (start > lastIndex) {
                annotatedStringList.add(
                    AnnotatedString.Range(
                        text.substring(lastIndex, start),
                        lastIndex,
                        start,
                        "text"
                    )
                )
            }
            annotatedStringList.add(
                AnnotatedString.Range(string, start, end, "link")
            )
            lastIndex = end
        }

        // Add remaining text
        if (lastIndex < text.length) {
            annotatedStringList.add(
                AnnotatedString.Range(
                    text.substring(lastIndex, text.length),
                    lastIndex,
                    text.length,
                    "text"
                )
            )
        }
        annotatedStringList
    }

    // Build an annotated string
    val annotatedString = buildAnnotatedString {
        annotatedStringList.forEach {
            if (it.tag == "link") {
                pushStringAnnotation(tag = it.tag, annotation = it.item)
                withStyle(style = primaryStyle) { append(it.item) }
                pop()
            } else {
                withStyle(style = textStyle) { append(it.item) }
            }
        }
    }

    ClickableText(
        text = annotatedString,
        style = typography.articleDescription,
        modifier = modifier,
        onClick = { position ->
            val annotatedStringRange =
                annotatedStringList.first { it.start < position && position < it.end }
            if (annotatedStringRange.tag == "link") onClick(annotatedStringRange.item)
        }
    )
}

@Preview
@Composable
fun PreviewTest() {
    NMGTheme {
        val string =
            "I am #hashtags or #hashtags# and @mentions in Jetpack Compose. I am #hashtags or #hashtags# and @mentions in Jetpack Compose. 這是在 Jetpack Compose 中的一個 #標簽 和 @提及 的超鏈接。 這是在 Jetpack Compose 中的一個 #標簽 和 @提及 的超鏈接。"

        HashtagsMentionsTextView(string, Modifier.padding(16.dp)) {
            println(it)
        }
    }
}
