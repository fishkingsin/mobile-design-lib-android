package com.nmg.mobile.design.gallery.demo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun GalleryApp(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = "Gallery") {
        composable("Gallery") { Gallery(navController) }
        composable("ColorPalette") { ColorPalette(/*...*/) }
        composable("SimpleComposeLayout") { SimpleComposeLayout(/*...*/) }

        /*...*/
    }


}

