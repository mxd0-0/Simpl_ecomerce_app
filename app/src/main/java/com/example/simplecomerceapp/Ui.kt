package com.example.simplecomerceapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.FractionalThreshold
import androidx.wear.compose.material.SwipeableState
import androidx.wear.compose.material.rememberSwipeableState
import androidx.wear.compose.material.swipeable
import kotlinx.coroutines.delay
import kotlin.math.roundToInt


@OptIn(ExperimentalWearMaterialApi::class)
@Composable
fun SwipeToAccessButton(modifier: Modifier) {//width.toPx() to "End"
    val dragnet = painterResource(id = R.drawable.btn)
    val width = 300.dp
    val swappableState: SwipeableState<Int> = rememberSwipeableState(0)
    val sizePx = with(LocalDensity.current) { width.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1)
    var show by remember { mutableStateOf(false) }



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
            .fillMaxSize()
            .padding(
                bottom = 60.dp
            )
    ) {
        Box(
            modifier = Modifier
                .width(width)
                .clip(CircleShape)
                .border(
                    BorderStroke(1.5.dp, Color.White),
                    shape = CircleShape
                )
                .swipeable(
                    state = swappableState,
                    anchors = anchors,
                    thresholds = { _, _ -> FractionalThreshold(0.7f) },
                    orientation = Orientation.Horizontal
                )
                .background(Color.Transparent)
        ) {


            Row(modifier = Modifier.fillMaxWidth()) {
                Icon(
                    painter = dragnet,
                    contentDescription = "DragButton",
                    tint = Color.White,
                    modifier = Modifier
                        .background(Color.Transparent)
                        .offset { IntOffset(swappableState.offset.value.roundToInt(), 0) }
                        .padding(9.dp)


                )
                Spacer(modifier = Modifier.width(40.dp))
                if (swappableState.offset.value == 0f) {

                    Text(
                        text = "SWIPE TO UNLOCK",
                        fontFamily = FontFamily.SansSerif, // sans-serif font
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                    )
                }

            }
        }
        if (show) {

            Text(
                text = "Thank You For Swiping",
                color = Color.Black,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp),
                textAlign = TextAlign.Center
            )
        }

    }

    LaunchedEffect(swappableState.currentValue) {
        if (swappableState.currentValue == 1) {
            show = true
            delay(3000)
            swappableState.animateTo(0)
        }
    }
}
//hello

@Composable
fun ProductCard(modifier: Modifier = Modifier) {
    Card(modifier = Modifier.clip(RoundedCornerShape(25.dp)),onClick = { /*TODO*/ }) {
        Column(
            modifier = modifier
                .wrapContentSize()
                .padding(16.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.btn_like1), contentDescription ="Like Button",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.End))
            Image(
                painter = painterResource(id = R.drawable.photo),
                contentDescription = "Shoe",
                alignment = Alignment.Center,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Saxophone Name",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 10.dp , bottom = 10.dp)
            )
            Text(
                text = "$27,00",
                fontSize = 16.sp,
                color = Color.Blue
            )
            Spacer(modifier = Modifier.height(5.dp))
            RatingBar(
                5f,
                modifier = Modifier.height(10.dp)
            )

        }

    }

    
}

@Preview
@Composable
private fun CardPreview() {
    ProductCard()

}