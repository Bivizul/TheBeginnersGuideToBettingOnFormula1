package com.bivizul.thebeginnersguidetobettingonformula1.node

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Parcelable
import android.util.Log
import android.widget.ProgressBar
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.hilt.navigation.compose.hiltViewModel
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.SetBehome
import com.bivizul.thebeginnersguidetobettingonformula1.node.behome.BehomeNode
import com.bivizul.thebeginnersguidetobettingonformula1.node.behome.BehomeViewModel
import com.bivizul.thebeginnersguidetobettingonformula1.node.helper.screenNode
import com.bivizul.thebeginnersguidetobettingonformula1.util.*
import com.bumble.appyx.core.composable.Children
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.bumble.appyx.core.node.ParentNode
import com.bumble.appyx.core.node.node
import com.bumble.appyx.navmodel.backstack.BackStack
import com.bumble.appyx.navmodel.backstack.activeRouting
import com.bumble.appyx.navmodel.backstack.operation.newRoot
import com.bumble.appyx.navmodel.backstack.operation.push
import com.bumble.appyx.navmodel.backstack.transitionhandler.rememberBackstackSlider
import com.skydoves.landscapist.coil.CoilImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.parcelize.Parcelize

sealed class Routing : Parcelable {
//    @Parcelize
//    object Child1 : Routing()
//
//    @Parcelize
//    object Child2 : Routing()
//
//    @Parcelize
//    object Child3 : Routing()

    @Parcelize
    object Home : Routing()

    @Parcelize
    object Behome : Routing()

}

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
) : ParentNode<Routing>(
    navModel = backStack,
    buildContext = buildContext
) {

    override fun resolve(routing: Routing, buildContext: BuildContext): Node =
        when (routing) {
//            Routing.Child1 -> screenNode(buildContext) { }
//            Routing.Child2 -> node(buildContext) { Text(text = "Placeholder for child 2") }
//            Routing.Child3 -> node(buildContext) { Text(text = "Placeholder for child 3") }
            Routing.Behome -> BehomeNode(buildContext)
            Routing.Home -> HomeNode(buildContext)
        }

    @Composable
    override fun View(modifier: Modifier) {

        Log.e("qwer", "RootNode")

        Children(
            navModel = backStack,
            transitionHandler = rememberBackstackSlider()
        )

//        backStack.push(
//            Routing.Home
//        )

        LaunchedEffect(backStack) {
//            if (backStack.activeRouting == Routing.Behome) {
                delay(2000)
                backStack.newRoot(Routing.Home)
//            }
        }

        /*val orientation = LocalConfiguration.current.orientation
        val image = when (orientation) {
            Configuration.ORIENTATION_PORTRAIT -> ConstBehome.BACK_P_101
            else -> ConstBehome.BACK_L_101
        }
        Box(modifier) {
            CoilImage(imageModel = image, contentScale = ContentScale.Crop)
            CircularProgressIndicator()
        }

        val behContext = LocalContext.current
        val behActivity = LocalContext.current as Activity

        val getBehome by behomeViewModel.behome.collectAsState(Resserv.LoadingR())
        Log.e("qwer", "RootNode getBehome : $getBehome")*/

        /*LaunchedEffect(backStack) {
//            if (backStack.activeRouting == Routing.Behome) {
//                delay(1000)
//
////                backStack.newRoot(Routing.Home)
//            }
//            CoroutineScope(Dispatchers.IO).launch {
//                if (backStack.activeRouting == Routing.Behome) {
            when (getBehome) {
                is Resserv.LoadingR -> {
                    Log.e("qwer", "RootNode Loading")
//                binding.progressBar.visibility = View.VISIBLE
                }
                is Resserv.SuccessR -> {
                    getBehome.data?.let { getBehome ->
                        Log.e("qwer", "RootNode SuccessR : $getBehome")
                        if (getBehome.getBehome == "no") {
//                                delay(1000)
//                        binding.progressBar.visibility = View.GONE
                            Log.e("qwer", "if")
//                            backStack.newRoot(Routing.Home)
//                            backStack.push(Routing.Home)
                            if (backStack.activeRouting == Routing.Behome) {
                                backStack.newRoot(Routing.Home)
                            }
                        } else {
//                                delay(1000)
//                        binding.progressBar.visibility = View.GONE
                            Log.e("qwer", "else")
//                            backStack.newRoot(Routing.Home)
//                            backStack.push(Routing.Home)
                            if (backStack.activeRouting == Routing.Behome) {
                                backStack.newRoot(Routing.Home)
                            }
                        }
                    }
                }
                is Resserv.ErrorR -> {
//                binding.progressBar.visibility = View.GONE
                    Log.e("qwer", "RootNode ErrorR block")
                    getDialogExit(behContext, behActivity)
                }
                else -> {
                    Log.e("qwer", "RootNode Else block")
                }
            }
//            }
//            }


        }*/


    }
}