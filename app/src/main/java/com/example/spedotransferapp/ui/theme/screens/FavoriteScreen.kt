package com.example.spedotransferapp.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
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
fun FavoritesScreen(navController: NavController) {
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
                painter = painterResource(id = R.drawable.outline_arrow_back_ios_new_24),
                contentDescription = "Back",
                tint = colorResource(id = R.color.Gray_G900),
                modifier = Modifier
                    .size(22.dp)
                    .clickable {
                        navController.navigate("your_previous_screen_route") // تغيير المسار حسب حاجتك
                    }
            )
            Text(
                text = "Favorite",
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth(0.93f),
                color = colorResource(id = R.color.Gray_G900), // يمكنك تغيير اللون ليكون متوافقًا مع التصميم الخاص بك
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.W500
            )
        }



        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .wrapContentSize()
        ) {

            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                text = "Your favorite List",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.Gray_G900)
            )
        }
        FavoritCard(recipientName = "Asmaa Dosuky", recipientAccount = "xxxx7890")
        FavoritCard(recipientName = "Asmaa Dosuky", recipientAccount = "xxxx7890")

    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    val navController = rememberNavController()
    FavoritesScreen(navController = navController)
}

@Composable
fun FavoritCard(recipientName:String , recipientAccount:String){
    Card (modifier = Modifier
        .fillMaxWidth()
        .padding(end = 16.dp, start = 16.dp, top = 16.dp, bottom = 5.dp)
        .height(88.dp)
        .background(Color.White)
    ){
        Row (modifier = Modifier
            .fillMaxSize()){

            Box(
                modifier = Modifier
                    .padding(top = 20.dp, start = 12.dp, bottom = 5.dp)
                    .size(48.dp)
                    .background(Color.LightGray, shape = CircleShape)
                    .clip(CircleShape)
            ) {
                Icon(
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.icon_banque),
                    contentDescription = null
                )
            }

            Column(
                modifier = Modifier.padding(
                    start = 20.dp,
                    top = 15.dp,
                    bottom = 5.dp
                )
            ) {

                Text(
                    color = colorResource(id = R.color.Gray_G900),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    text = recipientName
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.Gray_G100),
                    text = "Account $recipientAccount"
                )
            }
            Spacer(modifier = Modifier.padding(40.dp))
            Row (modifier = Modifier.align(Alignment.CenterVertically)){
                Image(modifier = Modifier
                    .clickable { }
                    .size(24.dp)
                    ,painter = painterResource(id = R.drawable.edit)
                    , contentDescription =null )
                Spacer(modifier = Modifier.padding(5.dp))
                Image(modifier = Modifier
                    .clickable { }
                    .size(24.dp)
                    ,painter = painterResource(id = R.drawable.delete)
                    , contentDescription =null )

            }

        }

    }
}





