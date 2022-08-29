package com.bivizul.thebeginnersguidetobettingonformula1.node.root

import android.app.Activity
import android.os.Parcelable
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.bivizul.thebeginnersguidetobettingonformula1.node.behome.BehomeNode
import com.bivizul.thebeginnersguidetobettingonformula1.node.behome.BehomeViewModel
import com.bivizul.thebeginnersguidetobettingonformula1.node.home.HomeNode
import com.bivizul.thebeginnersguidetobettingonformula1.util.Resserv
import com.bivizul.thebeginnersguidetobettingonformula1.util.behomeTab
import com.bivizul.thebeginnersguidetobettingonformula1.util.getDialogExit
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
            Routing.Behome -> BehomeNode(buildContext)
            Routing.Home -> HomeNode(
                buildContext = buildContext,
            )
        }

    @Composable
    override fun View(modifier: Modifier) {
        Children(
            navModel = backStack,
            transitionHandler = rememberBackstackSlider()
        )

        val behContext = LocalContext.current
        val behActivity = LocalContext.current as Activity
        val getBehome by behomeViewModel.behome.collectAsState(Resserv.LoadingR())

        CoroutineScope(Dispatchers.Main).launch {
            when (getBehome) {
                is Resserv.LoadingR -> {}
                is Resserv.SuccessR -> {
                    getBehome.data?.let { getBehome ->
                        if (getBehome.getBehome == "no") {
                            delay(1000)
                            backStack.newRoot(Routing.Home)
                        } else {
                            delay(1000)
                            behomeTab(behContext, getBehome.getBehome)
                            behActivity.finish()
                        }
                    }
                }
                is Resserv.ErrorR -> {
                    getDialogExit(behContext, behActivity)
                }
            }
        }
    }
}