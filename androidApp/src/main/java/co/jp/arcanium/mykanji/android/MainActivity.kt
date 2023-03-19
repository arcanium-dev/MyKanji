package co.jp.arcanium.mykanji.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import co.jp.arcanium.mykanji.android.home.presentation.HomeScreen
import co.jp.arcanium.mykanji.android.navigation.NavHost
import co.jp.arcanium.mykanji.android.navigation.Route
import co.jp.arcanium.mykanji.android.navigation.composable
import co.jp.arcanium.mykanji.android.navigation.navigate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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

                }
            }
        }
    }
}
