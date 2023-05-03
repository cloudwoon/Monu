package kr.co.woon.monu

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = {
                    bottomNavigationBar()
                },
                topBar = {
                    topAppBar()
                }

            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                ) {

                }

            }
        }
    }
}

@Composable
fun topAppBar() {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        title = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.top_logo),
                    contentDescription = "Monu 로고",
                    alignment = Alignment.Center
                )
            }
        },
        backgroundColor = Color(0xFFF3F4FF),
        elevation = 0.dp
    )
}

@Composable
fun bottomNavigationBar() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = remember {
        listOf("집중력향상법", "홈", "설정")
    }
    BottomNavigation(
        backgroundColor = Color(0xFFF3F4FF),
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}