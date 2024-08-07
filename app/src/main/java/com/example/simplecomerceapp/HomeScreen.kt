package com.example.simplecomerceapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.simplecomerceapp.ui.theme.uI.SaxophoneProducts


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
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
                Icon(painter = painterResource(id = R.drawable.vector),
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
                        .clickable(onClick = {
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
        SaxophoneProducts(
            navController
        )
    }
}

