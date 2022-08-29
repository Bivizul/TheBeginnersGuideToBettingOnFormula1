package com.bivizul.thebeginnersguidetobettingonformula1.node.spotlight

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.hilt.navigation.compose.hiltViewModel
import com.bivizul.thebeginnersguidetobettingonformula1.composable.ChildScreen
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.Guide
import com.bivizul.thebeginnersguidetobettingonformula1.ui.theme.*
import com.bivizul.thebeginnersguidetobettingonformula1.util.ConstBehome.KEY_COLOR_INDEX
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.bumble.appyx.core.state.MutableSavedStateMap
import kotlin.random.Random

@ExperimentalUnitApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
class ChildNode(
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
        val guideInViewModel: GuideViewModel = hiltViewModel()
        var gu = Guide(emptyList())
        guideInViewModel.guide.observe(LocalLifecycleOwner.current) {
            gu = it
        }
        if (gu != Guide(emptyList())) {
            gu.let {
                ChildScreen(
                    modifier = modifier,
                    color = color,
                    guide = it,
                    id = count,
                )

            }
        } else {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator()
            }
        }
    }
}