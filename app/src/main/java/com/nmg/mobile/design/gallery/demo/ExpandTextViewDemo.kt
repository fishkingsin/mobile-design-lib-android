package com.nmg.mobile.design.gallery.demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nmg.mobile.design.theme.NMGTheme
import com.nmg.mobile.design.widgets.reel.DefaultExpandTextView

@Composable
fun ExpandTextViewDemo() {
    Box {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            DefaultExpandTextView(
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl.",
                textColor = NMGTheme.colors.commonNeutralGray90
            )
            DefaultExpandTextView(
                content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl. Donec euismod, nisl eget ultricies aliquam, nisl nisl aliquet nisl, vitae aliquam nisl nisl vitae nisl.",
                textColor = NMGTheme.colors.commonNeutralGray90,
                collapseActionable = null
            )
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
fun ExpandTextViewDemoPreview() {
    ExpandTextViewDemo()
}
