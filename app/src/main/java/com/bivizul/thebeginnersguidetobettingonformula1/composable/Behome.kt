package com.bivizul.thebeginnersguidetobettingonformula1.composable

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import com.bivizul.thebeginnersguidetobettingonformula1.util.ConstBehome.BACK_L_101
import com.bivizul.thebeginnersguidetobettingonformula1.util.ConstBehome.BACK_P_101
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun Behome(
    modifier: Modifier = Modifier,
) {

    Log.e("qwer","Behome")

    val orientation = LocalConfiguration.current.orientation
    val image = when (orientation) {
        Configuration.ORIENTATION_PORTRAIT -> BACK_P_101
        else -> BACK_L_101
    }
    Box(modifier) {
        CoilImage(imageModel = image, contentScale = ContentScale.Crop)
    }
}

//@Preview(name = "Behome")
//@Composable
//private fun PreviewBehome() {
//    Behome()
//}