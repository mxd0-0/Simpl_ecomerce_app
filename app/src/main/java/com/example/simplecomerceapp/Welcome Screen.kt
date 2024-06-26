package com.example.simplecomerceapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.simplecomerceapp.ui.theme.primary
import com.example.simplecomerceapp.ui.theme.uI.SwipeToAccessButton

@Composable
fun Welcome(
    navController: NavController,
    /** onNavigate: () -> Unit,*/
    modifier: Modifier = Modifier
) {
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
                navController,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.BottomCenter)
            )
        }


    }
}