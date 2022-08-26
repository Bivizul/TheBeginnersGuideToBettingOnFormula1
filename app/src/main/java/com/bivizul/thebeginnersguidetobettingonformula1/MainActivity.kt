package com.bivizul.thebeginnersguidetobettingonformula1

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.hilt.navigation.compose.hiltViewModel
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.Guide
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.SetBehome
import com.bivizul.thebeginnersguidetobettingonformula1.node.root.RootNode
import com.bivizul.thebeginnersguidetobettingonformula1.node.behome.BehomeViewModel
import com.bivizul.thebeginnersguidetobettingonformula1.node.guide.GuideViewModel
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
                    val guideViewModel: GuideViewModel = hiltViewModel()
                    behomeViewModel.setBehome(SetBehome(getCapid(prefic), getSetBehome(this)))
//                    val guide by guideViewModel.guide.collectAsState(initial = Guide(emptyList()))
//                    Log.e("qwer","MainActivity guide : $guide")
                    Surface(color = MaterialTheme.colors.background) {
                        NodeHost(integrationPoint = integrationPoint) {
                            RootNode(
                                buildContext = it,
                                behomeViewModel = behomeViewModel,
//                                guideViewModel = guideViewModel,
//                                guide = guide,
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

//@Preview(showBackground = true)
//@Composable
//@ExperimentalUnitApi
//@ExperimentalAnimationApi
//@ExperimentalComposeUiApi
//fun DefaultPreview() {
//    TheBeginnersGuideToBettingOnFormula1Theme {
//        Column {
//            RootNode(buildContext = BuildContext.root(null)).Compose()
//        }
//    }
//}
