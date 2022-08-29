package com.bivizul.thebeginnersguidetobettingonformula1.composable

import android.content.res.Configuration
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import com.bivizul.thebeginnersguidetobettingonformula1.R
import com.bivizul.thebeginnersguidetobettingonformula1.node.home.HomeNode
import com.bivizul.thebeginnersguidetobettingonformula1.util.ConstBehome
import com.bumble.appyx.navmodel.backstack.BackStack
import com.bumble.appyx.navmodel.backstack.operation.push
import com.skydoves.landscapist.coil.CoilImage

@ExperimentalUnitApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    backStack: BackStack<HomeNode.Routing>,
) {

    val orientation = LocalConfiguration.current.orientation
    val image = when (orientation) {
        Configuration.ORIENTATION_PORTRAIT -> ConstBehome.BACK_P_101
        else -> ConstBehome.BACK_L_101
    }

    Box(
        modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CoilImage(imageModel = image, contentScale = ContentScale.Crop)
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h3
            )
            Button(
                onClick = {
                    backStack.push(HomeNode.Routing.Spotlight)
                },
                elevation = ButtonDefaults.elevation(disabledElevation = 4.dp),
                shape = MaterialTheme.shapes.large
            ) {
                Text(
                    text = stringResource(R.string.guide_button),
                    modifier = modifier.padding(16.dp),
                    style = MaterialTheme.typography.h4
                )
            }
        }
    }
}