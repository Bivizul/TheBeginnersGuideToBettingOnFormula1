package com.bivizul.thebeginnersguidetobettingonformula1.node.spotlight


import android.content.res.Configuration
import android.os.Parcelable
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import com.bivizul.thebeginnersguidetobettingonformula1.R
import com.bivizul.thebeginnersguidetobettingonformula1.node.spotlight.SpotlightNode.Item.*
import com.bivizul.thebeginnersguidetobettingonformula1.node.spotlight.SpotlightNode.Routing.*
import com.bivizul.thebeginnersguidetobettingonformula1.node.spotlight.SpotlightNode.State.Loaded
import com.bivizul.thebeginnersguidetobettingonformula1.node.spotlight.SpotlightNode.State.Loading
import com.bivizul.thebeginnersguidetobettingonformula1.util.ConstBehome
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
import com.skydoves.landscapist.coil.CoilImage
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
        if (spotlight.elementsCount() == 0) {
            screenState.value = Loading
            spotlight.updateElements(items = Item.getItemList())
            screenState.value = Loaded
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

        @Parcelize
        object Child8 : Routing()
    }

    @Parcelize
    private enum class Item(val routing: Routing) : Parcelable {
        G1(Child1),
        G2(Child2),
        G3(Child3),
        G4(Child4),
        G5(Child5),
        G6(Child6),
        G7(Child7),
        G8(Child8);

        companion object {
            fun getItemList() = values().map { it.routing }
        }
    }

    override fun resolve(routing: Routing, buildContext: BuildContext): Node =
        when (routing) {
            Child1 -> ChildNode(
                count = 0,
                buildContext = buildContext
            )
            Child2 -> ChildNode(
                count = 1,
                buildContext = buildContext
            )
            Child3 -> ChildNode(
                count = 2,
                buildContext = buildContext
            )
            Child4 -> ChildNode(
                count = 3,
                buildContext = buildContext
            )
            Child5 -> ChildNode(
                count = 4,
                buildContext = buildContext
            )
            Child6 -> ChildNode(
                count = 5,
                buildContext = buildContext
            )
            Child7 -> ChildNode(
                count = 6,
                buildContext = buildContext
            )
            Child8 -> ChildNode(
                count = 7,
                buildContext = buildContext
            )
        }

    @Composable
    override fun View(modifier: Modifier) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            LoadedState(modifier = modifier)
        }
    }

    @Composable
    private fun LoadedState(modifier: Modifier) {
        val hasPrevious = spotlight.hasPrevious().collectAsState(initial = false)
        val hasNext = spotlight.hasNext().collectAsState(initial = false)
        val orientation = LocalConfiguration.current.orientation
        val image = when (orientation) {
            Configuration.ORIENTATION_PORTRAIT -> ConstBehome.BACK_P_101
            else -> ConstBehome.BACK_L_101
        }

        Scaffold(
            modifier = modifier,
            bottomBar = {
                BottomAppBar(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(110.dp),
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    Column(modifier = modifier.fillMaxSize()) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(2.dp)
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            TextButton(
                                text = stringResource(R.string.g1),
                                enabled = true
                            ) {
                                spotlight.activate(G1)
                            }
                            TextButton(
                                text = stringResource(R.string.g2),
                                enabled = true
                            ) {
                                spotlight.activate(G2)
                            }
                            TextButton(
                                text = stringResource(R.string.g3),
                                enabled = true
                            ) {
                                spotlight.activate(G3)
                            }
                            TextButton(
                                text = stringResource(R.string.g4),
                                enabled = true
                            ) {
                                spotlight.activate(G4)
                            }
                            TextButton(
                                text = stringResource(R.string.g5),
                                enabled = true
                            ) {
                                spotlight.activate(G5)
                            }
                            TextButton(
                                text = stringResource(R.string.g6),
                                enabled = true
                            ) {
                                spotlight.activate(G6)
                            }
                            TextButton(
                                text = stringResource(R.string.g7),
                                enabled = true
                            ) {
                                spotlight.activate(G7)
                            }
                            TextButton(
                                text = stringResource(R.string.g8),
                                enabled = true
                            ) {
                                spotlight.activate(G8)
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(2.dp),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            TextButton(
                                text = stringResource(R.string.previous),
                                enabled = hasPrevious.value
                            ) {
                                spotlight.previous()
                            }
                            TextButton(
                                text = stringResource(R.string.back),
                                enabled = true
                            ) {
                                navigateUp()
                            }
                            TextButton(
                                text = stringResource(R.string.next),
                                enabled = hasNext.value
                            ) {
                                spotlight.next()
                            }
                        }
                    }

                }
            }
        ) { paddingValues ->
            CoilImage(imageModel = image, contentScale = ContentScale.Crop)
            Box(modifier = modifier.padding(paddingValues)) {
                Children(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState()),
                    transitionHandler = rememberSpotlightSlider(clipToBounds = true),
                    navModel = spotlight
                )
            }
        }
    }

    @Composable
    private fun TextButton(text: String, enabled: Boolean = true, onClick: () -> Unit) {
        Button(
            onClick = onClick,
            modifier = Modifier.padding(4.dp),
            enabled = enabled,
        ) {
            Text(text = text)
        }
    }

    private fun Spotlight<*>.activate(item: Item) {
        activate(item.ordinal)
    }
}