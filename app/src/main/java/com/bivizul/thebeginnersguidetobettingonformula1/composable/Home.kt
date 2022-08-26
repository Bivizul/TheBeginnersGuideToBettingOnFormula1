package com.bivizul.thebeginnersguidetobettingonformula1.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Home(
    modifier: Modifier = Modifier,
) {
    Box(modifier) {
        Text(text = "Home")
    }
}

@Preview(name = "Home")
@Composable
private fun PreviewHome() {
    Home()
}