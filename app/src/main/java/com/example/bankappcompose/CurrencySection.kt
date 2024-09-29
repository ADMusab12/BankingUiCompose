package com.example.bankappcompose

import android.graphics.drawable.Icon
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankappcompose.ui.theme.GreenStart
import java.nio.file.WatchEvent

val currencyList = listOf(
    com.example.bankappcompose.data.Currency(
        name = "USD",
        buy = 25.35f,
        sell = 25.35f,
        icon = Icons.Rounded.AttachMoney
    ),
    com.example.bankappcompose.data.Currency(
        name = "EUR",
        buy = 12.32f,
        sell = 12.32f,
        icon = Icons.Rounded.Euro
    ),
    com.example.bankappcompose.data.Currency(
        name = "YEN",
        buy = 55.35f,
        sell = 55.35f,
        icon = Icons.Rounded.CurrencyYen
    ),
    com.example.bankappcompose.data.Currency(
        name = "USD",
        buy = 65.35f,
        sell = 65.35f,
        icon = Icons.Rounded.AttachMoney
    ),
    com.example.bankappcompose.data.Currency(
        name = "EUR",
        buy = 22.32f,
        sell = 22.32f,
        icon = Icons.Rounded.Euro
    ),
    com.example.bankappcompose.data.Currency(
        name = "YEN",
        buy = 15.15f,
        sell = 15.15f,
        icon = Icons.Rounded.CurrencyYen
    ),
    com.example.bankappcompose.data.Currency(
        name = "USD",
        buy = 5.35f,
        sell = 5.35f,
        icon = Icons.Rounded.AttachMoney
    ),
    com.example.bankappcompose.data.Currency(
        name = "EUR",
        buy = 2.32f,
        sell = 2.32f,
        icon = Icons.Rounded.Euro
    ),
    com.example.bankappcompose.data.Currency(
        name = "YEN",
        buy = 5.15f,
        sell = 5.15f,
        icon = Icons.Rounded.CurrencyYen
    )

)


@Preview
@Composable
fun CurrencySection() {
    // todo mutable states
    var isVisible by remember {
        mutableStateOf(false)
    }

    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    //todo box
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp),
        contentAlignment = Alignment.BottomCenter
    ) {

        //todo column
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()
        ) {
            //todo row
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                //todo box
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.secondary)
                        .clickable {
                            isVisible = !isVisible
                            if (isVisible) {
                                iconState = Icons.Rounded.KeyboardArrowUp
                            } else {
                                iconState = Icons.Rounded.KeyboardArrowDown
                            }
                        }
                ) {
                    // todo icon
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = iconState,
                        contentDescription = "Currencies",
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }

                //todo spacer
                Spacer(modifier = Modifier.height(20.dp))

                //todo text
                Text(
                    text = "Currencies",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Bold
                )
            }

            //todo spacer
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onSecondaryContainer)
            )

            //todo if is visible
            if (isVisible) {
                BoxWithConstraints(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                        .background(MaterialTheme.colorScheme.background)
                ) {

                    val boxWithConstraintScope = this
                    val width = boxWithConstraintScope.maxWidth / 3

                    //todo column
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        //todo space
                        Spacer(modifier = Modifier.height(16.dp))

                        //todo row
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            //todo text
                            Text(
                                text = "Currency",
                                modifier = Modifier.width(width),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground
                            )
                            //todo text
                            Text(
                                text = "Buy",
                                modifier = Modifier.width(width),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End
                            )
                            //todo text
                            Text(
                                text = "Sell",
                                modifier = Modifier.width(width),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End
                            )
                        }

                        //todo space
                        Spacer(modifier = Modifier.height(16.dp))

                        //todo column
                        LazyColumn {
                            items(currencyList.size) { index ->
                                CurrencyItem(index = index, width = width)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CurrencyItem(index:Int,width:Dp){
    val currency = currencyList[index]
    //todo row
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        
        //todo row
        Row(
            modifier = Modifier.width(width),
            verticalAlignment = Alignment.CenterVertically
        ) {

            //todo box
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(GreenStart)
                    .padding(4.dp)
            ) {
                //todo icon
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = currency.icon,
                    contentDescription = currency.name,
                    tint = Color.White
                )
            }

            //todo text
            Text(
                text = currency.name,
                modifier = Modifier
                    .padding(start = 10.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }
        //todo text
        Text(
            text = "$ ${currency.buy}",
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )

        //todo text
        Text(
            text = "$ ${currency.sell}",
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.End
        )
    }
}