package kr.co.woon.monu

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class SearchActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFFFFFFFF)),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    statusBar()
                    topAppBar()

                    Box(modifier = Modifier.fillMaxWidth()) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.btn_back),
                                contentDescription = "뒤로가기",
                                modifier = Modifier
                                    .size(85.dp)
                                    .padding(start = 20.dp, top = 10.dp)
                                    .clickable(
                                        enabled = true,
                                        onClickLabel = "Clickable image",
                                        onClick = {
                                            Toast
                                                .makeText(
                                                    this@SearchActivity,
                                                    "Image clicked",
                                                    Toast.LENGTH_SHORT
                                                )
                                                .show()
                                        }
                                    ),

                                )
                            Image(
                                painter = painterResource(id = R.drawable.bg_text_search),
                                contentDescription = "단어 검색",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(70.dp)
                                    .padding(end = 20.dp, top = 10.dp),
                                contentScale = ContentScale.FillBounds
                            )
                        }
                    }

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.bg_search),
                            contentDescription = "단어검색 배경",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }


        }


    }

}

