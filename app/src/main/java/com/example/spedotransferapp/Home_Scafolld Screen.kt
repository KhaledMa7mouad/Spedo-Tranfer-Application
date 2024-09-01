import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomBottomNavigationScreen() {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            Surface(
                color = Color.Black,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp), // Rounded top corners
                elevation = 10.dp,
                modifier = Modifier.padding(bottom = 48.dp)
            ) {
                BottomNavigation(
                    backgroundColor = Color.Transparent, // Use Surface's color
                    contentColor = Color.Gray,
                    modifier = Modifier
                        .height(72.dp)
                        .fillMaxWidth() // Match the width of the parent container
                ) {
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Home",
                                tint = if (selectedIndex == 0) Color(0xFF8A1538) else Color.Gray
                            )
                        },
                        label = {
                            Text(
                                text = "Home",
                                fontSize = 10.sp,
                                color = if (selectedIndex == 0) Color(0xFF8A1538) else Color.Gray
                            )
                        },
                        selected = selectedIndex == 0,
                        onClick = { selectedIndex = 0 }
                    )
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Build,
                                contentDescription = "Transfer",
                                tint = if (selectedIndex == 1) Color(0xFF8A1538) else Color.Gray
                            )
                        },
                        label = {
                            Text(
                                text = "Transfer",
                                fontSize = 10.sp,
                                color = if (selectedIndex == 1) Color(0xFF8A1538) else Color.Gray
                            )
                        },
                        selected = selectedIndex == 1,
                        onClick = { selectedIndex = 1 }
                    )
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.AccountCircle,
                                contentDescription = "Transactions",
                                tint = if (selectedIndex == 2) Color(0xFF8A1538) else Color.Gray
                            )
                        },
                        label = {
                            Text(
                                text = "Transactions",
                                fontSize = 10.sp,
                                color = if (selectedIndex == 2) Color(0xFF8A1538) else Color.Gray
                            )
                        },
                        selected = selectedIndex == 2,
                        onClick = { selectedIndex = 2 }
                    )
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.AccountBox,
                                contentDescription = "My cards",
                                tint = if (selectedIndex == 3) Color(0xFF8A1538) else Color.Gray
                            )
                        },
                        label = {
                            Text(
                                text = "My cards",
                                fontSize = 10.sp,
                                color = if (selectedIndex == 3) Color(0xFF8A1538) else Color.Gray
                            )
                        },
                        selected = selectedIndex == 3,
                        onClick = { selectedIndex = 3 }
                    )
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "More",
                                tint = if (selectedIndex == 4) Color(0xFF8A1538) else Color.Gray
                            )
                        },
                        label = {
                            Text(
                                text = "More",
                                fontSize = 10.sp,
                                color = if (selectedIndex == 4) Color(0xFF8A1538) else Color.Gray
                            )
                        },
                        selected = selectedIndex == 4,
                        onClick = { selectedIndex = 4 }
                    )
                }
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues).fillMaxSize()
            ) {
                // Your screen content goes here
            }
        }
    )
}
