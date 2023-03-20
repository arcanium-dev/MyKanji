package co.jp.arcanium.mykanji.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import co.jp.arcanium.mykanji.android.home.presentation.HomeScreen
import co.jp.arcanium.mykanji.android.navigation.NavHost
import co.jp.arcanium.mykanji.android.navigation.Route
import co.jp.arcanium.mykanji.android.navigation.composable
import co.jp.arcanium.mykanji.android.navigation.navigate
import co.jp.arcanium.mykanji.android.revision.presentation.RevisionScreen
import co.jp.arcanium.mykanji.android.revision.presentation.RevisionViewModel
import co.jp.arcanium.mykanji.android.ui.MyKanjiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.setup()
        setContent {
            MyKanjiTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Route.Home
                ) {
                    composable(route = Route.Home) {
                        HomeScreen {
                            navController.navigate(Route.Revision)
                        }
                    }
                    composable(route = Route.Revision) {
                        val revisionViewModel: RevisionViewModel = hiltViewModel()
                        val revisionState by revisionViewModel.revisionState.collectAsStateWithLifecycle()
                        RevisionScreen(
                            onExitClicked = {
                                navController.navigate(Route.Home.route) {
                                    popUpTo(Route.Home.route)
                                }
                            },
                            revisionState = revisionState,
                            onIncorrectClicked = revisionViewModel::onIncorrectClicked,
                            onCorrectClicked = {},
                            setIsKanjiHidden = revisionViewModel::setIsKanjiHidden,
                        )
                    }
                }
            }
        }
    }
}
