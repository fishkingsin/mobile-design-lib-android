package com.nmg.mobile.design.gallery.demo

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Gallery(navigationController: NavController) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        // Add a single item
        item {
            Button(onClick = { navigationController.navigate("Colors") }) {
                Text(text = "Colors")
            }
        }
        item {
            Button(onClick = { navigationController.navigate("SimpleComposeLayout") }) {
                Text(text = "SimpleComposeLayout")
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GalleryPreview() {
    Gallery(navigationController = NavController(LocalContext.current))
}