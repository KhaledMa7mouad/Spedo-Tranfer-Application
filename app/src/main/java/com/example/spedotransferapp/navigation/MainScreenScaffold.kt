import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.spedotransferapp.navigation.Routes
import com.example.spedotransferapp.ui.theme.screens.AddCardScreen
import com.example.spedotransferapp.ui.theme.screens.EditPasswordScreen
import com.example.spedotransferapp.ui.theme.screens.EditProfileScreen
import com.example.spedotransferapp.ui.theme.screens.MoreScreen
import com.example.spedotransferapp.ui.theme.screens.NotificationScreen
import com.example.spedotransferapp.ui.theme.screens.SettingsScreen
import com.example.spedotransferapp.ui.theme.screens.SuccessTransactionScreen
import com.example.spedotransferapp.ui.theme.screens.TransactionsScreen
import com.example.spedotransferapp.ui.theme.screens.TransfareAmountScreen
import com.example.spedotransferapp.ui.theme.screens.TransferConfirmationScreen

@Composable
fun MainScreenScaffold() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) { paddingValues ->
        NavHost(route = Routes.SCAFFOLDSCREEN ,navController = navController, startDestination = BottomBarRoutes.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(BottomBarRoutes.Home.route) { HomeScreen(navController) }
            composable(BottomBarRoutes.Transfer.route) { TransfareAmountScreen(navController) }
            composable(BottomBarRoutes.Transactions.route) { TransactionsScreen(navController) }
            composable(BottomBarRoutes.Cards.route) { AddCardScreen(navController) }
            composable(BottomBarRoutes.More.route) { MoreScreen(navController) }

            composable(route = Routes.SETTINGS) {
                SettingsScreen(navController)
            }
            composable(route = Routes.EDITPROFILE) {
                EditProfileScreen(navController)
            }
            composable(route = Routes.EDITPASSWORD) {
                EditPasswordScreen(navController)
            }
            composable(route = Routes.TRANSFERAMOUNT) {
                TransfareAmountScreen(navController)
            }
            composable(
                route = "${Routes.TRANSFERCONFIRMATION}/{amount}/{recipientName}/{recipientAccount}",
                arguments = listOf(
                    navArgument("amount") { type = NavType.StringType },
                    navArgument("recipientName") { type = NavType.StringType },
                    navArgument("recipientAccount") { type = NavType.StringType }
                )
            ) {
                val amount = it.arguments?.getString("amount")!!
                val recipientName = it.arguments?.getString("recipientName")!!
                val recipientAccount = it.arguments?.getString("recipientAccount")!!

                TransferConfirmationScreen(
                    amount = amount,
                    recipientName = recipientName,
                    recipientAccount = recipientAccount,
                    navController = navController
                )
            }


            composable(route = Routes.SUCCESSFULTRANSACTION) {
                SuccessTransactionScreen(navController)
            }

            composable(route = Routes.NOTIFICATION) {
                NotificationScreen(navController)
            }


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
