import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.spedotransferapp.R

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFFFF7F0))
    ) {
        TopSection()
        Spacer(modifier = Modifier.height(20.dp))
        BalanceCard()
        Spacer(modifier = Modifier.height(20.dp))
        TransactionsSection()
    }
}

@Composable
fun TopSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 36.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.LightGray, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "AD", // You can replace this with dynamic initials
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = "Welcome back,", color = Color.Red, fontSize = 14.sp)
                Text(text = "Khaled Mahmoud", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
        Icon(
            imageVector = Icons.Filled.Notifications,
            contentDescription = "Notifications",
            tint = Color.Black,
            modifier = Modifier
                .size(32.dp)
                .clickable {  }
        )
    }
}

@Composable
fun BalanceCard() {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFA21830)),
        modifier = Modifier
            .fillMaxWidth()
            .height(128.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Current Balance",
                color = Color.White,
                fontSize = 14.sp,
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "10000EGP",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
            )
        }
    }
}

@Composable
fun TransactionsSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Recent transactions", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(
            text = "View all",
            color = Color.Gray,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
    Spacer(modifier = Modifier.height(12.dp))

    LazyColumn(
        contentPadding = PaddingValues(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp) // Adds spacing between items
    ) {
        items(7) { // Change this to 7 items
            TransactionItem()
        }
    }

}

@Composable
fun TransactionItem() {
    Card(
        shape = RoundedCornerShape(12.dp),
       colors = CardDefaults.cardColors(containerColor = Color.White),
       elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_email_24), // Replace with your resource
                contentDescription = "Card Logo",
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.LightGray, shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = "Ahmed Mohamed", fontWeight = FontWeight.Bold)
                Text(text = "Visa · Master Card · 1234", color = Color.Gray, fontSize = 12.sp,fontWeight = FontWeight.SemiBold)
                Text(text = "Today 11:00 · Received", color = Color.Gray, fontSize = 12.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "500EGP", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewBankScreen() {
//    BankScreen()
//}