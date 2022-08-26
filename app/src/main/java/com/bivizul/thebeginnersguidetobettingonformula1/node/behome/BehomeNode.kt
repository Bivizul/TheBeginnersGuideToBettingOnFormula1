package com.bivizul.thebeginnersguidetobettingonformula1.node.behome

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.bivizul.thebeginnersguidetobettingonformula1.composable.Behome
import com.bumble.appyx.core.composable.Children
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.bumble.appyx.navmodel.backstack.transitionhandler.rememberBackstackSlider

@ExperimentalUnitApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
class BehomeNode(
    buildContext: BuildContext,
) : Node(
    buildContext = buildContext,
) {


    @Composable
    override fun View(modifier: Modifier) {
        Log.e("qwer","BehomeNode")

        Behome()

    }
}