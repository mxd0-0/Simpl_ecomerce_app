package com.example.simplecomerceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
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
import com.example.simplecomerceapp.ui.theme.primary
import kotlinx.coroutines.delay
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hello()
//
        }
    }
}

@Composable
fun Hello(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = primary)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.height(150.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                tint = Color.White,
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = modifier.size(
                    50.dp
                )
            )
            Text(
                text = "STORE NAME",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = modifier.height(50.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Search for best",
                color = Color.White.copy(alpha = 0.5f),
                fontSize = 28.sp

            )
            Text(
                text = "Musical instrument",
                color = Color.White.copy(alpha = 0.5f),
                fontSize = 28.sp

            )
        }
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                alignment = Alignment.BottomStart,
                painter = painterResource(id = R.drawable.women),
                contentDescription = "women",
                modifier = Modifier.fillMaxSize()
            )
            SwipeToAccessButton(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.BottomCenter)
            )
        }


    }
}

//onClick: () -> Unit
@OptIn(ExperimentalWearMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun SwipeToAccessButton(modifier: Modifier) {//width.toPx() to "End"
    val dragnet = painterResource(id = R.drawable.btn)
    val width = 300.dp
    val swappableState: SwipeableState<Int> = rememberSwipeableState(0)
    val sizePx = with(LocalDensity.current) { width.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1)
    var show by remember { mutableStateOf(false) }
    var show1 by remember { mutableStateOf(false) }
    var showText by remember { mutableStateOf(true) }


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


@Preview(showBackground = true)
@Composable
fun Hh() {
    Box(modifier = Modifier.fillMaxSize()) {
        Hello()

    }

}






