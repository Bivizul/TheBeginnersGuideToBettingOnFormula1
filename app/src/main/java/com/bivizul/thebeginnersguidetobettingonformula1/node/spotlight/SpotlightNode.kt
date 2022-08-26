package com.bivizul.thebeginnersguidetobettingonformula1.node.spotlight


import android.os.Parcelable
import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.lifecycle.coroutineScope
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.Guide
import com.bivizul.thebeginnersguidetobettingonformula1.node.guide.GuideViewModel
import com.bivizul.thebeginnersguidetobettingonformula1.node.spotlight.SpotlightNode.Item.*
import com.bivizul.thebeginnersguidetobettingonformula1.node.spotlight.SpotlightNode.Routing.*
import com.bivizul.thebeginnersguidetobettingonformula1.node.spotlight.SpotlightNode.State.Loaded
import com.bivizul.thebeginnersguidetobettingonformula1.node.spotlight.SpotlightNode.State.Loading
import com.bivizul.thebeginnersguidetobettingonformula1.util.Resserv
import com.bumble.appyx.core.composable.Children
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.bumble.appyx.core.node.ParentNode
import com.bumble.appyx.navmodel.spotlight.Spotlight
import com.bumble.appyx.navmodel.spotlight.backpresshandler.GoToPrevious
import com.bumble.appyx.navmodel.spotlight.elementsCount
import com.bumble.appyx.navmodel.spotlight.hasNext
import com.bumble.appyx.navmodel.spotlight.hasPrevious
import com.bumble.appyx.navmodel.spotlight.operation.activate
import com.bumble.appyx.navmodel.spotlight.operation.next
import com.bumble.appyx.navmodel.spotlight.operation.previous
import com.bumble.appyx.navmodel.spotlight.operation.updateElements
import com.bumble.appyx.navmodel.spotlight.transitionhandler.rememberSpotlightSlider
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.parcelize.Parcelize

@ExperimentalUnitApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
class SpotlightNode(
    buildContext: BuildContext,
    private val spotlight: Spotlight<Routing> = Spotlight(
        items = emptyList(),
        savedStateMap = buildContext.savedStateMap,
        backPressHandler = GoToPrevious(),
    ),
//    private val guideViewModel: GuideViewModel,
//    val guide: Guide,
) : ParentNode<SpotlightNode.Routing>(
    buildContext = buildContext,
    navModel = spotlight
) {

    private val screenState = mutableStateOf<State?>(null)

    sealed class State {
        object Loading : State()
        object Loaded : State()
    }

    init {
        // simulate loading tabs
        if (spotlight.elementsCount() == 0) {

            screenState.value = Loading
//            lifecycle.coroutineScope.launch {
//                delay(2000)
            spotlight.updateElements(items = Item.getItemList())
            screenState.value = Loaded
//            }
        } else {
            screenState.value = Loaded
        }
    }

    sealed class Routing : Parcelable {
        @Parcelize
        object Child1 : Routing()

        @Parcelize
        object Child2 : Routing()

        @Parcelize
        object Child3 : Routing()

        @Parcelize
        object Child4 : Routing()

        @Parcelize
        object Child5 : Routing()

        @Parcelize
        object Child6 : Routing()

        @Parcelize
        object Child7 : Routing()
    }

    @Parcelize
    private enum class Item(val routing: Routing) : Parcelable {
        C1(Child1),
        C2(Child2),
        C3(Child3),
        C4(Child4),
        C5(Child5),
        C6(Child6),
        C7(Child7);

        companion object {
            fun getItemList() = values().map { it.routing }
        }
    }

    override fun resolve(routing: Routing, buildContext: BuildContext): Node =
        when (routing) {
            Child1 -> ChildNode(
//                guideViewModel = guideViewModel,
//                guide=guide,
                count = 0,
                buildContext = buildContext
            )
            Child2 -> ChildNode(
//                guideViewModel = guideViewModel,
//                guide=guide,
                count = 1,
                buildContext = buildContext
            )
            Child3 -> ChildNode(
//                guideViewModel = guideViewModel,
//                guide=guide,
                count = 2,
                buildContext = buildContext
            )
            Child4 -> ChildNode(
//                guideViewModel = guideViewModel,
//                guide=guide,
                count = 3,
                buildContext = buildContext
            )
            Child5 -> ChildNode(
//                guideViewModel = guideViewModel,
//                guide=guide,
                count = 4,
                buildContext = buildContext
            )
            Child6 -> ChildNode(
//                guideViewModel = guideViewModel,
//                guide=guide,
                count = 5,
                buildContext = buildContext
            )
            Child7 -> ChildNode(
//                guideViewModel = guideViewModel,
//                guide=guide,
                count = 6,
                buildContext = buildContext
            )
        }

    @Composable
    override fun View(modifier: Modifier) {

//        val guide by guideViewModel.guide.collectAsState(initial = Resserv.LoadingR())
//        Log.e("qwer", "SpotlightNode guide : $guide")

        Log.e("qwer", "SpotlightNode")
        val state by screenState

        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
//            when (state) {
//                is Loading -> CircularProgressIndicator()
//                is Loaded -> LoadedState(modifier = modifier)
//                else -> Unit
//            }
            LoadedState(modifier = modifier)
        }
    }

    @Composable
    private fun LoadedState(modifier: Modifier) {
        val hasPrevious = spotlight.hasPrevious().collectAsState(initial = false)
        val hasNext = spotlight.hasNext().collectAsState(initial = false)
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(
                    text = "Previous",
                    enabled = hasPrevious.value
                ) {
                    spotlight.previous()
                }
                TextButton(
                    text = "Next",
                    enabled = hasNext.value
                ) {
                    spotlight.next()
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextButton(
                    text = "C1",
                    enabled = true
                ) {
                    spotlight.activate(C1)
                }
                TextButton(
                    text = "C2",
                    enabled = true
                ) {
                    spotlight.activate(C2)
                }
                TextButton(
                    text = "C3",
                    enabled = true
                ) {
                    spotlight.activate(C3)
                }
                TextButton(
                    text = "C4",
                    enabled = true
                ) {
                    spotlight.activate(C4)
                }
                TextButton(
                    text = "C5",
                    enabled = true
                ) {
                    spotlight.activate(C5)
                }
                TextButton(
                    text = "C6",
                    enabled = true
                ) {
                    spotlight.activate(C6)
                }
                TextButton(
                    text = "C7",
                    enabled = true
                ) {
                    spotlight.activate(C7)
                }
            }

            Children(
                modifier = Modifier
                    .padding(top = 12.dp, bottom = 12.dp)
                    .fillMaxWidth(),
                transitionHandler = rememberSpotlightSlider(clipToBounds = true),
                navModel = spotlight
            )

        }
    }

    @Composable
    private fun TextButton(text: String, enabled: Boolean = true, onClick: () -> Unit) {
        Button(onClick = onClick, enabled = enabled, modifier = Modifier.padding(4.dp)) {
            Text(text = text)
        }
    }

    private fun Spotlight<*>.activate(item: Item) {
        activate(item.ordinal)
    }
}