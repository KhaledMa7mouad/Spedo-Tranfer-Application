package com.example.spedotransferapp.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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

@OptIn(ExperimentalSubclassOptIn::class, ExperimentalMaterial3Api::class)
@Composable
fun MoreScreen(navController: NavController) {
    val background = Brush.verticalGradient(
        listOf(colorResource(id = R.color.Greadient2), colorResource(id = R.color.Gredient)),
        startY = 2000f,
        endY = 0f
    )

    val context = LocalContext.current




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
                painter = painterResource(id = R.drawable.outline_arrow_back_ios_new_24),
                contentDescription = "Back",
                tint = colorResource(id = R.color.Gray_G900),
                modifier = Modifier
                    .size(22.dp)
                    .clickable {
                        navController.navigate("your_previous_screen_route")
                    }
            )
            Text(
                text = "More",
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth(0.93f),
                color = colorResource(id = R.color.Gray_G900),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W500
            )
        }


        MoreField(
            "Transfer from website",
            leadingIcon = R.drawable.web_site,
        )
        MoreField(
            "Favourites",
            leadingIcon = R.drawable.star,

        )
        MoreField(
            "Profile",
            leadingIcon = R.drawable.user,
        )
        MoreField(
            "Help",
            leadingIcon = R.drawable.question,
            onClick = {
                navController.navigate("help")
            }

        )
        MoreField(
            "Logout",
            leadingIcon = R.drawable.log_out
        )
    }
}




@Composable
fun MoreField(
    headLine: String = "",
    leadingIcon: Int = 0,
    trailingIcon: Int = R.drawable.next,
    color: Color = Color.Transparent,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .clickable { onClick()},
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = color)
                    .size(30.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = leadingIcon),
                    contentDescription = "",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Column {
                Text(text = headLine, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
        Icon(
            painter = painterResource(id = trailingIcon),
            contentDescription = "",
            modifier = Modifier.size(25.dp)
        )

    }
    HorizontalDivider(
        thickness = 1.dp,
        color = Color.Gray,
        modifier = Modifier.padding(horizontal = 10.dp)
    )
}




@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MoreScreenPreview() {
    val navController = rememberNavController()
    MoreScreen(navController = navController)
}











