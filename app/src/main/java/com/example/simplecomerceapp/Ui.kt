package com.example.simplecomerceapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.graphics.painter.Painter
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
import kotlin.random.Random


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
fun ProductCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    pImage: Painter,
    productName: String,
    price: Int,
    like: Boolean,
    rating: Float
) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(25.dp))
            .padding(
                start = 5.dp,
                end = 5.dp,
                top = 10.dp,
                bottom = 20.dp
            ), onClick = onClick
    ) {
        Column(
            modifier = modifier.background(Color.White)
                .wrapContentWidth()
                .height(350.dp)
                .padding(10.dp)

        ) {
            Image(
                painter = if (like) painterResource(id = R.drawable.btn_like1) else painterResource(
                    id = R.drawable.btn_unlike
                ),
                contentDescription = "Like Button",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.End)
            )
            Image(
                painter = pImage,
                contentDescription = "ProductName",
                alignment = Alignment.Center,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = productName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
                    .fillMaxWidth()
                    .height(47.dp)
            )
            Text(
                text = "$$price",
                fontSize = 16.sp,
                color = Color.Blue
            )
            Spacer(modifier = Modifier.height(5.dp))
            RatingBar(
                rating,
                modifier = Modifier.height(17.dp)
            )

        }

    }


}

@Composable
fun SaxophoneProducts() {
    val color = Color(0xFFF5EDE1)
    val productNames = listOf(
        "Alto Saxophone",
        "Tenor Saxophone",
        "Baritone Saxophone",
        "Soprano Saxophone",
        "Bass Saxophone"
    )
    Column {
        Text(
            text = "Saxophone Product",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 40.dp, start = 15.dp, bottom = 10.dp)
        )


        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                start = 10.dp,
                end = 10.dp,
                top = 10.dp,
                bottom = 10.dp
            ),
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(color)
        ) {
            items(6) {
                ProductCard(
                    pImage = painterResource(id = R.drawable.photo),
                    productName = productNames.random(),
                    price = Random.nextInt(from = 100, until = 350),
                    rating = Random.nextFloat() * (5.0f - 1.0f) + 1.0f,
                    like = Random.nextBoolean()
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun He() {
    SaxophoneProducts()
}

