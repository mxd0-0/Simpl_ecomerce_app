package com.example.simplecomerceapp.ui.theme.uI

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
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
import androidx.navigation.NavController
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.FractionalThreshold
import androidx.wear.compose.material.SwipeableState
import androidx.wear.compose.material.rememberSwipeableState
import androidx.wear.compose.material.swipeable
import com.example.simplecomerceapp.R
import kotlin.math.roundToInt
import kotlin.random.Random


@OptIn(ExperimentalWearMaterialApi::class)
@Composable
fun SwipeToAccessButton(
    navController: NavController,
    /** onNavigate: () -> Unit
    ,*/
    modifier: Modifier
) {//width.toPx() to "End"
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
                    BorderStroke(1.5.dp, Color.White), shape = CircleShape
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
                Icon(painter = dragnet,
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
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }

            }
        }
        if (show) {
            navController.navigate("Home")


        }

    }

    LaunchedEffect(swappableState.currentValue) {
        if (swappableState.currentValue == 1) {
            show = true
            //    swappableState.animateTo(0)
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
                start = 5.dp, end = 5.dp, top = 10.dp, bottom = 20.dp
            ), onClick = onClick
    ) {
        Column(
            modifier = modifier
                .background(Color.White)
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
                text = "$$price", fontSize = 16.sp, color = Color.Blue
            )
            Spacer(modifier = Modifier.height(5.dp))
            RatingBar(
                rating, modifier = Modifier.height(17.dp)
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
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(color)
            .fillMaxSize()
    ) {
        Text(
            text = "Choose Type",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 40.dp, start = 15.dp, bottom = 10.dp)
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            ShowType(painterResource(id = R.drawable.saxophone))
            ShowType(painterResource(id = R.drawable.gutar))
            ShowType(painterResource(id = R.drawable.piano))
        }


        Text(
            text = "Saxophone Product",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 25.dp, start = 15.dp, bottom = 10.dp)
        )


        LazyVerticalGrid(
            columns = GridCells.Fixed(2), contentPadding = PaddingValues(
                start = 10.dp, end = 10.dp,

                bottom = 10.dp
            ), modifier = Modifier.background(Color.Transparent)
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

@Composable
fun ShowType(image: Painter) {
    Card(
        modifier = Modifier.size(width = 100.dp, height = 64.dp),
        shape = RoundedCornerShape(13.dp),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContentColor = Color.LightGray,
            disabledContainerColor = Color.White
        )


    ) {
        Image(
            painter = image,
            contentDescription = "Type",
            alignment = Alignment.Center,
            modifier = Modifier
                .padding(13.dp)
                .fillMaxSize()
        )
    }

}

@Composable
fun ProductDescription(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Color", fontSize = 20.sp, fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun ColorPicker(
    colors: List<Color>, selectedColor: MutableState<Color>
) {
    Column(
        modifier = Modifier.fillMaxWidth()

    ) {
        Text(text = "Color", fontSize = 16.sp, color = Color.Black)
        Spacer(modifier = Modifier.height(10.dp))
          Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start){
            colors.forEach { color ->
                Box(modifier = Modifier
                    .size(24.dp)
                    .background(
                        color = color, shape = CircleShape
                    )
                    .clickable { selectedColor.value = color }
                    .border(
                        width = if (color == selectedColor.value) 3.dp else 0.dp,
                        color = if (color == selectedColor.value) Color.White else Color.Transparent,
                        shape = CircleShape
                    )
                    .padding(vertical = 10.dp)
                )
                Spacer(modifier = Modifier.width(15.dp) )
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun TextDescription(modifier: Modifier = Modifier) {
    val color1 = Color(0xFFF5EDE1)
    val orange = Color(0xFFFFB84D)
    val colors = listOf(Color(0xFFFFC107), Color(0xFFBDBDBD), Color.Black)
    val selectedColor by remember { mutableStateOf(Color(0xFFBDBDBD)) }

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
            .background(Color.White)
            .fillMaxWidth()
            .padding(15.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        ColorPicker(colors = colors, selectedColor = mutableStateOf(selectedColor))
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Details", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Includes:")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Case for Saxophone \"GL CASES\" (The specification of a custom-made product by Wood Stone) Neck Swab Body Swab Cloth Smooth Pad")
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = color1),
                modifier = Modifier.width(156.dp)
            ) {
                Text(text = "Add to Cart", color = Color.Black)

            }
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = orange),
                modifier = Modifier.width(156.dp)
            ) {
                Text(text = "Buy Now", color = Color.White)

            }


        }

    }
}

@Preview(showSystemUi = true)
@Composable
private fun text() {
    TextDescription()

}

@SuppressLint("UnrememberedMutableState")
@Preview()
@Composable
private fun PreviewColorPicker() {
    val colors = listOf(Color(0xFFFFC107), Color(0xFFBDBDBD), Color.Black)
    val selectedColor by remember { mutableStateOf(Color(0xFFBDBDBD)) }

    ColorPicker(colors = colors, selectedColor = mutableStateOf(selectedColor))
}

