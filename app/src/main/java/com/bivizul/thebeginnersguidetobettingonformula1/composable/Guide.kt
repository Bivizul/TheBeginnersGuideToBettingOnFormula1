package com.bivizul.thebeginnersguidetobettingonformula1.composable

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.Guide
import com.bivizul.thebeginnersguidetobettingonformula1.node.root.RootNode
import com.bivizul.thebeginnersguidetobettingonformula1.util.Resserv
import com.bivizul.thebeginnersguidetobettingonformula1.util.getDialogExit
import com.bumble.appyx.navmodel.backstack.operation.newRoot
import kotlinx.coroutines.delay

@Composable
fun Guide(
    modifier: Modifier = Modifier,
    guide : Guide
) {

    Log.e("qwer", "Guide")

    Box(modifier) {
        Text(text = "Guide : ${guide.guide[0].title}")
    }



}

//@Preview(name = "Guide")
//@Composable
//private fun PreviewGuide() {
//    Guide()
//}