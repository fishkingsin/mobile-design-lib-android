package com.nmg.mobile.design.gallery.demo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun GalleryApp(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = "Gallery") {
        composable("Gallery") { Gallery(navController) }
        composable("ColorPalette") { ColorPalette(/*...*/) }
        composable("CardDemo") { CardDemo(/*...*/) }
        composable("TypographyDemo") { TypographyDemo(/*...*/) }
        composable("IconDemo") { IconDemo(/*...*/) }
        composable("SimpleComposeLayout") { SimpleComposeLayout(/*...*/) }

        /*...*/
    }
}
