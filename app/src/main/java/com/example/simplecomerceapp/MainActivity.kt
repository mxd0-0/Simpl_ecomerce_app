package com.example.simplecomerceapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecomerceapp.ui.theme.primary

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Myapp()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Myapp(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column {


        TopAppBar(modifier = Modifier.fillMaxWidth(), title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val color = Color(0xFFFFB84D)

                Icon(
                    tint = color,
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Store Name",
                    color = color,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
            }

        }, navigationIcon = {
            Row {


                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    painter = painterResource(id = R.drawable.vector),
                    contentDescription = null,
                    modifier = Modifier
                        .size(19.dp)

                        .clickable(onClick = {
                            Toast
                                .makeText(
                                    context, "Nothing included in design", Toast.LENGTH_SHORT
                                )
                                .show()
                        })
                )
            }
        }, actions = {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search Button",
                    modifier = Modifier
                        .size(19.dp)
                        .clickable(
                            onClick = {
                            Toast
                                .makeText(
                                    context, "Nothing included in design", Toast.LENGTH_SHORT
                                )
                                .show()
                        })

                )
                Spacer(modifier = Modifier.width(10.dp))
            }
        }

        )
        SaxophoneProducts()
    }
}


@Preview(showBackground = true)
@Composable
private fun Scaffold() {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        Myapp()
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
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Search for best", color = Color.White.copy(alpha = 0.5f), fontSize = 28.sp

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












