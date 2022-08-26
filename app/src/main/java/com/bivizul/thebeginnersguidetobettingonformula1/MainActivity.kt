package com.bivizul.thebeginnersguidetobettingonformula1

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.hilt.navigation.compose.hiltViewModel
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.SetBehome
import com.bivizul.thebeginnersguidetobettingonformula1.node.RootNode
import com.bivizul.thebeginnersguidetobettingonformula1.node.behome.BehomeViewModel
import com.bivizul.thebeginnersguidetobettingonformula1.ui.theme.TheBeginnersGuideToBettingOnFormula1Theme
import com.bivizul.thebeginnersguidetobettingonformula1.util.*
import com.bumble.appyx.core.integration.NodeHost
import com.bumble.appyx.core.integrationpoint.NodeActivity
import com.bumble.appyx.core.modality.BuildContext
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
                    behomeViewModel.setBehome(SetBehome(getCapid(prefic), getSetBehome(this)))

                    Surface(color = MaterialTheme.colors.background) {
                        NodeHost(integrationPoint = integrationPoint) {
                            RootNode(
                                buildContext = it,
                                behomeViewModel = behomeViewModel
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
