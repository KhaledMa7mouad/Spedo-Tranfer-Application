package com.example.spedotransferapp.ui.theme.screens


import android.graphics.Color.parseColor
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.spedotransferapp.R

@Composable
fun Profile(navController: NavController) {
    val background = Brush.verticalGradient(
        listOf(colorResource(id = R.color.Greadient2), colorResource(id = R.color.Gredient)),
        startY = 2000f,
        endY = 0f
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 32.dp, top = 44.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                contentDescription = "Back",
                tint = colorResource(id = R.color.Gray_G900),
                modifier = Modifier
                    .size(22.dp)
                    .clickable {
                        navController.navigate("your_previous_screen_route")
                    }
            )
            Text(
                text = "Profile",
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth(0.93f),
                color = colorResource(id = R.color.Gray_G900),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W500
            )
        }

        ProfileName()
        MoreField(
            title = "Personal information",
            description = "Your information",
            icon = R.drawable.ic_profile,
            onClick = { navController.navigate("personal_info_route") }
        )
        MoreField(
            title = "Setting",
            description = "Change your settings",
            icon = R.drawable.ic_settings,
            onClick = { navController.navigate("settings_route") }
        )
        MoreField(
            title = "Payment history",
            description = "View your transactions",
            icon = R.drawable.ic_history_3x,
            onClick = { navController.navigate("payment_history_route") }
        )
        MoreField(
            title = "My favourite list",
            description = "View your favourites",
            icon = R.drawable.ic_favourite,
            onClick = { navController.navigate("favourite_list_route") }
        )
    }
}

@Composable
fun ProfileName() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(5.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(Color(0xFFccced3))
                .size(48.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "MS", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.Gray)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Mohamed Sherif",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Black
        )
    }
}
@Composable
fun MoreField(title: String, description: String, icon: Int, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(40.dp)

        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black
            )
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = { onClick() }) {
            Icon(
                painter = painterResource(id = R.drawable.outline_arrow_forward_ios_24),
                contentDescription = "Navigate",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

val String.color
    get() = Color(parseColor(this))

@Preview(showSystemUi = true, showBackground = true)

@Composable
fun MyComposablePreview() {
    val navController = rememberNavController()
    Profile(navController = navController)
}
