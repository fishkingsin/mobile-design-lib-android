package com.nmg.mobile.design.gallery.demo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nmg.mobile.design.widgets.reel.ReelsView

@Composable
fun GalleryApp(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Gallery") {
        composable("TVPOC") { TVPOCScreen() }
        composable("Reels") { ReelsView() }
        composable("Gallery") { Gallery(navController) }
        composable("ColorPalette") { ColorPalette() }
        composable("CardDemo") { CardDemo() }
        composable("TypographyDemo") { TypographyDemo() }
        composable("IconDemo") { IconDemo() }
        composable("SimpleComposeLayout") { SimpleComposeLayout() }
        composable("YoutubeHelper") { YoutubeHelperExampleView() }
        composable("VideoExampleView") { VideoExampleView() }
    }
}
