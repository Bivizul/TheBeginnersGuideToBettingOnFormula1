package com.bivizul.thebeginnersguidetobettingonformula1.node

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.bivizul.thebeginnersguidetobettingonformula1.composable.Home
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node

@ExperimentalUnitApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
class HomeNode(
    buildContext: BuildContext,
) : Node(
    buildContext = buildContext
) {

    @Composable
    override fun View(modifier: Modifier) {
        Log.e("qwer","HomeNode")
        Home()

    }

}