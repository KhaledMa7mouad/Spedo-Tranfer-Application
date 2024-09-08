import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.spedotransferapp.ui.theme.screens.TransactionsScreen
import com.example.spedotransferapp.ui.theme.screens.TransfareAmountScreen

@Composable
fun MainScreenScaffold() {
    val navController = rememberNavController()




    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { paddingValues ->
        NavHost(navController = navController, startDestination = BottomBarRoutes.Home.route, Modifier.padding(paddingValues)) {
            composable(BottomBarRoutes.Home.route) { HomeScreen(navController) }
            composable(BottomBarRoutes.Transfer.route) { TransfareAmountScreen(navController) }
            composable(BottomBarRoutes.Transactions.route) { TransactionsScreen(navController) }
            composable(BottomBarRoutes.Cards.route) { /* Cards Screen Content */ }
            composable(BottomBarRoutes.More.route) { /* More Screen Content */ }
        }
    }
}

@Composable
fun BottomBar(navController: NavController) {
    val screens = listOf(
        BottomBarRoutes.Home,
        BottomBarRoutes.Transfer,
        BottomBarRoutes.Transactions,
        BottomBarRoutes.Cards,
        BottomBarRoutes.More
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Gray
    ) {
        screens.forEach { screen ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = screen.title,
                        tint = if (currentDestination?.route == screen.route) Color(0xFF8A1538) else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = screen.title,
                        fontSize = 10.sp,
                        color = if (currentDestination?.route == screen.route) Color(0xFF8A1538) else Color.Gray
                    )
                },
                selected = currentDestination?.route == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

object BottomBarRoutes {
    val Home = Screen("Home", Icons.Default.Home )
    val Transfer = Screen("Transfer", Icons.Default.CheckCircle)
    val Transactions = Screen("Transactions", Icons.Default.Refresh)
    val Cards = Screen("Cards", Icons.Default.Person)
    val More = Screen("More", Icons.Default.MoreVert)

    data class Screen(val route: String, val icon: ImageVector, val title: String = route)
}

@Preview
@Composable
private fun MainScreenScaffoldPrev() {
    MainScreenScaffold()
}
