package com.bivizul.thebeginnersguidetobettingonformula1.node.root

import android.app.Activity
import android.os.Parcelable
import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.Guide
import com.bivizul.thebeginnersguidetobettingonformula1.node.behome.BehomeNode
import com.bivizul.thebeginnersguidetobettingonformula1.node.behome.BehomeViewModel
import com.bivizul.thebeginnersguidetobettingonformula1.node.guide.GuideViewModel
import com.bivizul.thebeginnersguidetobettingonformula1.node.home.HomeNode
import com.bivizul.thebeginnersguidetobettingonformula1.util.*
import com.bumble.appyx.core.composable.Children
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.bumble.appyx.core.node.ParentNode
import com.bumble.appyx.navmodel.backstack.BackStack
import com.bumble.appyx.navmodel.backstack.operation.newRoot
import com.bumble.appyx.navmodel.backstack.transitionhandler.rememberBackstackSlider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.parcelize.Parcelize


@ExperimentalUnitApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
class RootNode(
    val buildContext: BuildContext,
    private val backStack: BackStack<Routing> = BackStack(
        initialElement = Routing.Behome,
        savedStateMap = buildContext.savedStateMap,
    ),
    val behomeViewModel: BehomeViewModel,
//    val guideViewModel: GuideViewModel,
//    val guide: Guide
) : ParentNode<RootNode.Routing>(
    navModel = backStack,
    buildContext = buildContext
) {

    sealed class Routing : Parcelable {

        @Parcelize
        object Home : Routing()

        @Parcelize
        object Behome : Routing()

    }

    override fun resolve(routing: Routing, buildContext: BuildContext): Node =
        when (routing) {
//            Routing.Child1 -> screenNode(buildContext) { }
//            Routing.Child2 -> node(buildContext) { Text(text = "Placeholder for child 2") }
//            Routing.Child3 -> node(buildContext) { Text(text = "Placeholder for child 3") }
            Routing.Behome -> BehomeNode(buildContext)
            Routing.Home -> HomeNode(
                buildContext = buildContext,
//                guideViewModel = guideViewModel,
//                guide=guide
            )
        }

    @Composable
    override fun View(modifier: Modifier) {

        Log.e("qwer", "RootNode")

        Children(
            navModel = backStack,
            transitionHandler = rememberBackstackSlider()
        )

        val behContext = LocalContext.current
        val behActivity = LocalContext.current as Activity

        val getBehome by behomeViewModel.behome.collectAsState(Resserv.LoadingR())
        Log.e("qwer", "RootNode getBehome : $getBehome")

        CoroutineScope(Dispatchers.Main).launch {
            when (getBehome) {
                is Resserv.LoadingR -> {
                    Log.e("qwer", "RootNode Loading")
                }
                is Resserv.SuccessR -> {
                    getBehome.data?.let { getBehome ->
                        Log.e("qwer", "RootNode SuccessR : $getBehome")
                        if (getBehome.getBehome == "no") {
                            Log.e("qwer", "ifi")
//                            LaunchedEffect(backStack) {
                            delay(1000)
                            backStack.newRoot(Routing.Home)
//                            }
                        } else {
                            Log.e("qwer", "elsei")
//                            LaunchedEffect(backStack) {
                            delay(1000)
                            backStack.newRoot(Routing.Home)
//                            }
                        }
                    }
                }
                is Resserv.ErrorR -> {
                    Log.e("qwer", "RootNode ErrorR block")
                    getDialogExit(behContext, behActivity)
                }
            }
        }


    }
}