package com.nmg.mobile.design.gallery.demo

import android.os.Bundle
import android.view.*
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.compose.rememberNavController
import com.nmg.mobile.design.ThemeManager
import com.nmg.mobile.design.theme.NMGDefaultColors
import com.nmg.mobile.design.theme.NMGTheme

class ComposeDemoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ThemeManager.setCustomizedThemes(this.requireContext(), "ww")
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                NMGTheme(colors = NMGDefaultColors(LocalContext.current)) {
                    val navController = rememberNavController() // Leave this one
                    GalleryApp(navController)
                }
            }
        }
    }
}