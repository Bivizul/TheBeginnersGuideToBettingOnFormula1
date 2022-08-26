package com.bivizul.thebeginnersguidetobettingonformula1.composable

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.bivizul.thebeginnersguidetobettingonformula1.node.home.HomeNode
import com.bumble.appyx.navmodel.backstack.BackStack
import com.bumble.appyx.navmodel.backstack.operation.newRoot
import com.bumble.appyx.navmodel.backstack.operation.push

@ExperimentalUnitApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun Home(
    modifier: Modifier = Modifier,
    backStack:BackStack<HomeNode.Routing>
) {

    Log.e("qwer", "Home")

    Box(
        modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            Text(text = "Home")
            Button(
                onClick = {
                    backStack.push(HomeNode.Routing.Guide)
                }
            ) {
                Text(text = "Guide")
            }
            Button(
                onClick = {
                    backStack.push(HomeNode.Routing.Spotlight)
                }
            ) {
                Text(text = "Spotlight")
            }
        }
    }
}

//@Preview(name = "Home")
//@Composable
//private fun PreviewHome() {
//    Home()
//}