package com.bivizul.thebeginnersguidetobettingonformula1.node.spotlight

import android.app.Activity
import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.Guide
import com.bivizul.thebeginnersguidetobettingonformula1.node.guide.GuideViewModel
import com.bivizul.thebeginnersguidetobettingonformula1.node.root.RootNode
import com.bivizul.thebeginnersguidetobettingonformula1.ui.theme.*
import com.bivizul.thebeginnersguidetobettingonformula1.util.Resserv
import com.bivizul.thebeginnersguidetobettingonformula1.util.getDialogExit
import com.bumble.appyx.core.composable.Children
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.bumble.appyx.core.state.MutableSavedStateMap
import com.bumble.appyx.navmodel.backstack.operation.newRoot
import com.bumble.appyx.navmodel.backstack.transitionhandler.rememberBackstackSlider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

@ExperimentalUnitApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
class ChildNode(
//    private val name: String,
//    private val guide: Guide,
//    private val guideViewModel: GuideViewModel,
    private val count: Int,
    buildContext: BuildContext,
) : Node(
    buildContext = buildContext,
) {

    private val colors = listOf(red1, red2, red3, red4, red5, red6, red7)

    private val colorIndex =
        buildContext.savedStateMap?.get(KEY_COLOR_INDEX) as? Int ?: Random.nextInt(colors.size)
    private val color = colors[colorIndex]

    override fun onSaveInstanceState(state: MutableSavedStateMap) {
        super.onSaveInstanceState(state)
        state[KEY_COLOR_INDEX] = colorIndex
    }

    @Composable
    override fun View(modifier: Modifier) {
        Log.e("qwer", "ChildNode")
        val chilContext = LocalContext.current
        val chilActivity = LocalContext.current as Activity

        val guideInViewModel: GuideViewModel = hiltViewModel()

//        val guideIn by guideInViewModel.guide.collectAsState(initial = Guide(emptyList()))
//        Log.e("qwer", "ChildNode guide : $guideIn")
//        CoroutineScope(Dispatchers.Main).launch {

        var gu = Guide(emptyList())
        guideInViewModel.guide.observe(LocalLifecycleOwner.current) {
            gu = it
        }
        Log.e("qwer", "ChildNode gu : $gu")

        if (gu != Guide(emptyList())) {
            gu.let {
                Log.e("qwer", "ChildNode SuccessR")
                ChildScreen(
                    modifier = modifier,
                    color = color,
                    guide = it,
                    id = count,
                    navigateUp = { navigateUp() }
                )

            }
        }



        Box(modifier = modifier.fillMaxSize(), contentAlignment = Center) {
            CircularProgressIndicator()
        }

        /* when (guide) {
             is Resserv.LoadingR -> {
                 Log.e("qwer", "ChildNode LoadingR")
 //                Box(modifier = modifier) {
 //                    CircularProgressIndicator()
 //                }
             }
             is Resserv.SuccessR -> {
                 guide.data?.let { guide ->
                     Log.e("qwer", "ChildNode SuccessR")
                     ChildScreen(
                         modifier = modifier,
                         color = color,
                         guide = guide,
                         id = count,
                         navigateUp = navigateUp()
                     )

                 }
             }
             is Resserv.ErrorR -> {
                 Log.e("qwer", "ChildNode ErrorR block")
                 getDialogExit(chilContext, chilActivity)
             }
         }*/
//
//        }
    }

    companion object {
        private const val KEY_COLOR_INDEX = "ColorIndex"
    }
}

@Composable
fun ChildScreen(
    modifier: Modifier,
    color: Color,
    guide: Guide,
    id: Int,
    navigateUp: () -> Unit,
) {

    Log.e("qwer", "ChildScreen")

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = color,
                shape = RoundedCornerShape(6.dp)
            )
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
//                Text("Child ($name).")
            Text("Child (${guide.guide[id].title}).")
            Row {
                // Local UI state should be saved too (both in backstack and onSaveInstanceState)
                var counter by rememberSaveable { mutableStateOf(0) }
                Text(text = "Counter $counter", modifier = Modifier.align(CenterVertically))
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = { counter++ }) {
                    Text("Increment")
                }
            }
            Row {
                Button(
                    onClick = navigateUp
                ) {
                    Text("Go up")
                }
            }
        }
    }
}

//@Preview
//@Composable
//fun ChildPreview() {
//    ChildNode("1", BuildContext.root(null)).Compose()
//}
