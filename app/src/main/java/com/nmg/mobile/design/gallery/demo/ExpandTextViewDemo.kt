package com.nmg.mobile.design.gallery.demo

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.reel.DefaultExpandTextView

@Composable
fun ExpandTextViewDemo() {
    Box {
        DefaultExpandTextView(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl.",
            textColor = NMGTheme.colors.commonNeutralGray90
        )
    }
}

@Composable
@Preview
fun ExpandTextViewDemoPreview() {
    ExpandTextViewDemo()
}
