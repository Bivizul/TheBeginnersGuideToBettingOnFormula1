package com.bivizul.thebeginnersguidetobettingonformula1.composable

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import com.bivizul.thebeginnersguidetobettingonformula1.util.ConstBehome.BACK_L_101
import com.bivizul.thebeginnersguidetobettingonformula1.util.ConstBehome.BACK_P_101
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun BehomeScreen(
    modifier: Modifier = Modifier,
) {
    val orientation = LocalConfiguration.current.orientation
    val image = when (orientation) {
        Configuration.ORIENTATION_PORTRAIT -> BACK_P_101
        else -> BACK_L_101
    }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CoilImage(imageModel = image, contentScale = ContentScale.Crop)
        CircularProgressIndicator()
    }
}