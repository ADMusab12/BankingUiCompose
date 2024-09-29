package com.example.bankappcompose

import android.bluetooth.BluetoothA2dp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MonetizationOn
import androidx.compose.material.icons.rounded.StarHalf
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankappcompose.data.Finance
import com.example.bankappcompose.ui.theme.BlueStart
import com.example.bankappcompose.ui.theme.GreenStart
import com.example.bankappcompose.ui.theme.OrangeStart
import com.example.bankappcompose.ui.theme.PurpleStart

val financeList = listOf(
    Finance(
        image = Icons.Rounded.StarHalf,
        name = "My\nBusiness",
        background = OrangeStart
    ),
    Finance(
        image = Icons.Rounded.Wallet,
        name = "My\nWallet",
        background = BlueStart
    ),
    Finance(
        image = Icons.Rounded.StarHalf,
        name = "Finance\nAnalytics",
        background = PurpleStart
    ),
    Finance(
        image = Icons.Rounded.MonetizationOn,
        name = "My\nTransactions",
        background = GreenStart
    )
)

@Preview
@Composable
fun FinanceSection(){
    //todo column
    Column {
        //todo text
        Text(
            text = "Finance",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(16.dp)
        )

        //todo lazy row
        LazyRow{
            items(financeList.size){
                FinanceItem(it)
            }
        }
    }
}

@Composable
fun FinanceItem(index:Int){
    //todo item and padding
    val finance = financeList[index]
    var lastPaddingEnd = 0.dp
    if (index == financeList.size - 1){
        lastPaddingEnd = 16.dp
    }
    //todo Box
    Box(modifier = Modifier.padding(start = 16.dp, end = lastPaddingEnd)) {

        //todo column
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .size(120.dp)
                .clickable {}
                .padding(13.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            //todo Box
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.background)
                    .padding(6.dp)
            ) {
                //todo icon
                Icon(
                    imageVector = finance.image,
                    contentDescription = finance.name,
                    tint = Color.White
                )
            }

            //todo text
            Text(
                text = finance.name,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
