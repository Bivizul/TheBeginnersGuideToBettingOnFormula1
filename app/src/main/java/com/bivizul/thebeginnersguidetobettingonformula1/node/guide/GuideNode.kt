package com.bivizul.thebeginnersguidetobettingonformula1.node.guide

import android.os.Parcelable
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.bivizul.thebeginnersguidetobettingonformula1.composable.Guide
import com.bivizul.thebeginnersguidetobettingonformula1.composable.Home
import com.bivizul.thebeginnersguidetobettingonformula1.node.home.HomeNode
import com.bumble.appyx.core.composable.Children
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.bumble.appyx.core.node.ParentNode
import com.bumble.appyx.navmodel.backstack.BackStack
import com.bumble.appyx.navmodel.backstack.transitionhandler.rememberBackstackSlider
import kotlinx.parcelize.Parcelize

class GuideNode(
    buildContext: BuildContext,
    private val backStack: BackStack<Routing> = BackStack(
        initialElement = Routing.GuideS,
        savedStateMap = buildContext.savedStateMap,
    ),

) : ParentNode<GuideNode.Routing>(
    navModel = backStack,
    buildContext = buildContext
) {

    sealed class Routing : Parcelable {

        @Parcelize
        object GuideS : Routing()


    }

    override fun resolve(routing: Routing, buildContext: BuildContext): Node =
        when(routing){
            Routing.GuideS ->GuideScreen(buildContext)
        }

    @Composable
    override fun View(modifier: Modifier) {
        Log.e("qwer", "GuideNode")



        Children(
            navModel = backStack,
            transitionHandler = rememberBackstackSlider()
        )



//        Guide()

    }


}