package com.nmg.mobile.design.gallery.demo

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun GalleryApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Gallery") {
        composable("Gallery") { Gallery(navController) }
        composable("Colors") { ColorPalette(/*...*/) }
        composable("SimpleComposeLayout") { SimpleComposeLayout(/*...*/) }

        /*...*/
    }


}

