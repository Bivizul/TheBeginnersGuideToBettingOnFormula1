package com.bivizul.thebeginnersguidetobettingonformula1.node.behome

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.hilt.navigation.compose.hiltViewModel
import com.bivizul.thebeginnersguidetobettingonformula1.composable.Behome
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.GetBehome
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.SetBehome
import com.bivizul.thebeginnersguidetobettingonformula1.node.Routing
import com.bivizul.thebeginnersguidetobettingonformula1.util.*
import com.bivizul.thebeginnersguidetobettingonformula1.util.ConstBehome.PREFIC_NAME
import com.bumble.appyx.core.composable.Children
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.bumble.appyx.navmodel.backstack.BackStack
import com.bumble.appyx.navmodel.backstack.operation.newRoot
import com.bumble.appyx.navmodel.backstack.transitionhandler.rememberBackstackSlider
import kotlinx.coroutines.*

@ExperimentalUnitApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
class BehomeNode(
    buildContext: BuildContext,
    private val backStack: BackStack<Routing> = BackStack(
        initialElement = Routing.Behome,
        savedStateMap = buildContext.savedStateMap,
    ),
) : Node(
    buildContext = buildContext,
) {

//    lateinit var behomeViewModel : BehomeViewModel

    @Composable
    override fun View(modifier: Modifier) {
        Log.e("qwer","BehomeNode")

        val behContext = LocalContext.current
        val behActivity = LocalContext.current as Activity
        val behomeViewModel: BehomeViewModel = hiltViewModel()

        val getBehome by behomeViewModel.behome.collectAsState(Resserv.LoadingR())
        Log.e("qwer", "RootNode getBehome : $getBehome")

        LaunchedEffect(backStack) {
//            if (backStack.activeRouting == Routing.Behome) {
//                delay(1000)
//
//                backStack.newRoot(Routing.Home)
//            }
            /*CoroutineScope(Dispatchers.Main).launch {
//                if (backStack.activeRouting == Routing.Behome) {
                when (getBehome) {
                    is Resserv.LoadingR -> {
                        Log.e("qwer", "RootNode Loading")
//                binding.progressBar.visibility = View.VISIBLE
                    }
                    is Resserv.SuccessR -> {
                        getBehome.data?.let { getBehome ->
                            Log.e("qwer", "RootNode getBehome : $getBehome")
                            if (getBehome.getBehome == "no") {
                                delay(1000)
//                        binding.progressBar.visibility = View.GONE
                                backStack.newRoot(Routing.Home)
                            } else {
                                delay(1000)
//                        binding.progressBar.visibility = View.GONE

                                backStack.newRoot(Routing.Home)
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
            }*/
//            }
        }

        // Let's add the children to the composition
//        Children(
//            navModel = backStack,
//            transitionHandler = rememberBackstackSlider()
//        )

        // Let's also add some controls so we can test it
        /*Row {
            TextButton(onClick = { backStack.push(Routing.Child1) }) {
                Text(text = "Push child 1")
            }
            TextButton(onClick = { backStack.push(Routing.Child2) }) {
                Text(text = "Push child 2")
            }
            TextButton(onClick = { backStack.push(Routing.Child3) }) {
                Text(text = "Push child 3")

                TextButton(onClick = { backStack.pop() }) {
                    Text(text = "Pop")
                }
            }
            Row {
                TextButton(onClick = { backStack.push(Routing.Behome) }) {
                    Text(text = "Push Behome")
                }
                TextButton(onClick = { backStack.push(Routing.Home) }) {
                    Text(text = "Push Home")
                }
                TextButton(onClick = { backStack.pop() }) {
                    Text(text = "Pop")
                }
            }
        }*/

        Behome()

    }
}