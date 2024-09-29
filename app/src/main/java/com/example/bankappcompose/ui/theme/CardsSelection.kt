package com.example.bankappcompose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankappcompose.R
import com.example.bankappcompose.data.Card

val cards = listOf(
    Card(
        cardName = "Business",
        cardBalance = 122.2,
        cardNumber = "9864 5234 6787 0098",
        cardType = "VISA",
        cardColor = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardName = "Student",
        cardBalance = 25.0,
        cardNumber = "0090 3456 1476 0989",
        cardType = "MASTER CARD",
        cardColor = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardName = "Travel",
        cardBalance = 155.6,
        cardNumber = "6787 3456 0090 1267",
        cardType = "VISA",
        cardColor = getGradient(OrangeStart, OrangeEnd)
    ),
    Card(
        cardName = "Secured",
        cardBalance = 122.2,
        cardNumber = "9878 7878 5364 9800",
        cardType = "MASTER CARD",
        cardColor = getGradient(GreenStart, GreenEnd)
    )
)

fun getGradient(startColor: Color, endColor: Color): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Composable
fun CardsSelection() {
    LazyRow {
        items(cards.size) { index ->
            CardItem(index)
        }
    }
}

@Preview
@Composable
fun CardItem(index: Int) {
    //todo card index and padding
    val card = cards[index]
    var lastCardPadding = 0.dp
    if (index == cards.size - 1) {
        lastCardPadding = 16.dp
    }

    //todo card image
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.ic_master)
    }

    //todo box
    Box(
        modifier = Modifier.padding(start = 16.dp, end = lastCardPadding)
    ) {
        //todo column
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.cardColor)
                .width(250.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            //todo image
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp),
            )
            
            //todo space
            Spacer(modifier = Modifier.height(10.dp))
            
            //todo text
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            //todo text
            Text(
                text = "$ ${card.cardBalance}",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            //todo text
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}