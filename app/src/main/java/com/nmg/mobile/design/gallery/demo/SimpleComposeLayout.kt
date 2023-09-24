package com.nmg.mobile.design.gallery.demo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.nmg.mobile.design.gallery.R
import com.nmg.mobile.design.theme.NMGTheme

@Composable
fun SimpleComposeLayout(message: String = "Hello from Compose!") {
    Column(Modifier.fillMaxSize()) {
        Text(
            text = stringResource(R.string.title),
            style = NMGTheme.typography.headlineEmphasize,
        )
        Text(
            text = stringResource(R.string.subtitle),
            style = NMGTheme.typography.headlineEmphasize,
        )
        Text(
            text = message,
            style = NMGTheme.typography.body,
        )
        Text(
            text = stringResource(R.string.body),
            style = NMGTheme.typography.body,
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { /* Handle click */ }, Modifier.fillMaxWidth()) {
            Text(text = stringResource(R.string.confirm))
        }
    }
}
