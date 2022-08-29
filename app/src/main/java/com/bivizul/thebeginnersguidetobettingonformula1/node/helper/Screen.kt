package com.bivizul.thebeginnersguidetobettingonformula1.node.helper

import androidx.compose.runtime.Composable
import com.bivizul.thebeginnersguidetobettingonformula1.composable.ScreenCenteredContent
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node
import com.bumble.appyx.core.node.node

internal fun screenNode(buildContext: BuildContext, content: @Composable () -> Unit): Node =
    node(buildContext) { modifier -> ScreenCenteredContent(modifier, content) }