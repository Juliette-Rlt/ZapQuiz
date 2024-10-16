package fr.imt.atlantique.codesvi.app.ui.screens.multi


import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import fr.imt.atlantique.codesvi.app.ui.navigation.HomeRootScreen

@Composable
fun rememberMultiState(navController: NavHostController): MultiState {
    return remember(navController) {
        MultiState(navController)
    }
}

@Stable
class MultiState(private val navController: NavHostController) {

    fun navigateTo(
        screen : HomeRootScreen
    ) = navController.navigate(screen.route) {
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

}