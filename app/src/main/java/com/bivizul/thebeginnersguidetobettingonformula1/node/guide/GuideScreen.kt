package com.bivizul.thebeginnersguidetobettingonformula1.node.guide

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.bivizul.thebeginnersguidetobettingonformula1.composable.Guide
import com.bivizul.thebeginnersguidetobettingonformula1.util.Resserv
import com.bivizul.thebeginnersguidetobettingonformula1.util.getDialogExit
import com.bumble.appyx.core.modality.BuildContext
import com.bumble.appyx.core.node.Node

class GuideScreen(
    buildContext: BuildContext,
) : Node(
    buildContext = buildContext
) {

    @Composable
    override fun View(modifier: Modifier) {

        val guiContext = LocalContext.current
        val guiActivity = LocalContext.current as Activity
//        val viewModel: GuideViewModel = hiltViewModel()
//        val guide by viewModel.guide.collectAsState(initial = Resserv.LoadingR())

        /*when (guide) {
            is Resserv.LoadingR -> {
                Log.e("qwer", "RootNode Loading")
//                binding.progressBar.visibility = View.VISIBLE
                Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
            is Resserv.SuccessR -> {
                guide.data?.let { guide ->
                    Log.e("qwer", "RootNode SuccessR : $guide")
//                    backStack.newRoot(RootNode.Routing.Home)
                    Guide(guide = guide)
                }
            }
            is Resserv.ErrorR -> {
//                binding.progressBar.visibility = View.GONE
                Log.e("qwer", "RootNode ErrorR block")
                getDialogExit(guiContext, guiActivity)
            }
            else -> {
                Log.e("qwer", "RootNode Else block")
            }
        }*/


    }

}