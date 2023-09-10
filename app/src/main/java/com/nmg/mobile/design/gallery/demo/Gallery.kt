package com.nmg.mobile.design.gallery.demo

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nmg.mobile.design.theme.NMGTheme

@Composable
fun Gallery(navigationController: NavController) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        item {
            Button(onClick = { navigationController.navigate("Reels") }) {
                Text(text = "Reels")
            }
        }
        // Add a single item
        item {
            Button(onClick = { navigationController.navigate("ColorPalette") }) {
                Text(text = "Color")
            }
        }
        item {
            Button(onClick = { navigationController.navigate("IconDemo") }) {
                Text(text = "IconDemo")
            }
        }
        item {
            Button(onClick = { navigationController.navigate("CardDemo") }) {
                Text(text = "Card")
            }
        }
        item {
            Button(onClick = { navigationController.navigate("TypographyDemo") }) {
                Text(text = "Typography")
            }
        }
        item {
            Button(onClick = { navigationController.navigate("SimpleComposeLayout") }, colors = ButtonDefaults.buttonColors(backgroundColor = NMGTheme.colors.primary)) {
                Text(text = "SimpleComposeLayout")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GalleryPreview() {
    NMGTheme {
        Gallery(navigationController = NavController(LocalContext.current))
    }
}
