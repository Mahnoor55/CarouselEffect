package com.genetum.carouseleffect

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carousel.compose.CarouselEffect
import com.genetum.carouseleffect.ui.theme.Card1
import com.genetum.carouseleffect.ui.theme.Card2
import com.genetum.carouseleffect.ui.theme.Card3
import com.genetum.carouseleffect.ui.theme.Card4
import com.genetum.carouseleffect.ui.theme.Card5
import com.genetum.carouseleffect.ui.theme.Card6
import com.genetum.carouseleffect.ui.theme.CarouselEffectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarouselEffectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CarouselScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Composable
fun CarouselScreen(modifier: Modifier) {
val context = LocalContext.current

    val cardList = listOf(Card1, Card2, Card3, Card4, Card5, Card6)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CarouselEffect(listSize = cardList.size, onClick = { index ->
            Toast.makeText(context, "You clicked on card $index", Toast.LENGTH_SHORT).show()
        }) { index ->
            Card(
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(containerColor = cardList[index]),
                modifier = Modifier.fillMaxSize()
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "Card $index",
                        modifier = Modifier.align(Alignment.Center),
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}