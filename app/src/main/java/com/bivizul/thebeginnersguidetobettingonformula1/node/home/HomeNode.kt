package com.bivizul.thebeginnersguidetobettingonformula1.node.home

import android.os.Parcelable
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.bivizul.thebeginnersguidetobettingonformula1.composable.HomeScreen
import com.bivizul.thebeginnersguidetobettingonformula1.node.helper.screenNode
import com.bivizul.thebeginnersguidetobettingonformula1.node.spotlight.SpotlightNode
import com.bumble.appyx.core.composable.Children
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.bumble.appyx.core.node.ParentNode
import com.bumble.appyx.navmodel.backstack.BackStack
import com.bumble.appyx.navmodel.backstack.transitionhandler.rememberBackstackSlider
import kotlinx.parcelize.Parcelize

@ExperimentalUnitApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
class HomeNode(
    buildContext: BuildContext,
    private val backStack: BackStack<Routing> = BackStack(
        initialElement = Routing.Homik,
        savedStateMap = buildContext.savedStateMap,
    ),
) : ParentNode<HomeNode.Routing>(
    navModel = backStack,
    buildContext = buildContext
) {
    sealed class Routing : Parcelable {
        @Parcelize
        object Homik : Routing()

        @Parcelize
        object Spotlight : Routing()
    }

    override fun resolve(routing: Routing, buildContext: BuildContext): Node =
        when (routing) {
            Routing.Homik -> screenNode(buildContext) { HomeScreen(backStack = backStack) }
            Routing.Spotlight -> SpotlightNode(
                buildContext = buildContext,
            )
        }

    @Composable
    override fun View(modifier: Modifier) {
        Children(
            navModel = backStack,
            transitionHandler = rememberBackstackSlider()
        )
    }
}