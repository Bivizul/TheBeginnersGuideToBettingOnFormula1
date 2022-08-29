package com.bivizul.thebeginnersguidetobettingonformula1

import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.hilt.navigation.compose.hiltViewModel
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.SetBehome
import com.bivizul.thebeginnersguidetobettingonformula1.node.behome.BehomeViewModel
import com.bivizul.thebeginnersguidetobettingonformula1.node.root.RootNode
import com.bivizul.thebeginnersguidetobettingonformula1.ui.theme.TheBeginnersGuideToBettingOnFormula1Theme
import com.bivizul.thebeginnersguidetobettingonformula1.util.*
import com.bumble.appyx.core.integration.NodeHost
import com.bumble.appyx.core.integrationpoint.NodeActivity
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalUnitApi
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : NodeActivity() {

    private val prefic by lazy {
        this.getSharedPreferences(ConstBehome.PREFIC_NAME, Context.MODE_PRIVATE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheBeginnersGuideToBettingOnFormula1Theme {
                if (checkConMan(this)) {

                    val behomeViewModel: BehomeViewModel = hiltViewModel()
                    try {
                        behomeViewModel.setBehome(
                            SetBehome(
                                getCapid(prefic),
                                getSetBehome(this),
                                getTimeZone(),
                                getSimLoc(this),
                                getManModel()
                            )
                        )
                    } catch (e: Exception) {
                        getDialogExit(context = this, activity = this)
                    }
                    Surface(color = MaterialTheme.colors.background) {
                        NodeHost(integrationPoint = integrationPoint) {
                            RootNode(
                                buildContext = it,
                                behomeViewModel = behomeViewModel,
                            )
                        }
                    }
                } else {
                    getDialogExit(context = this, activity = this)
                }
            }
        }
    }
}