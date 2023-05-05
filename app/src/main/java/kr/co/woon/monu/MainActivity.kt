package kr.co.woon.monu

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        val fontFamily = FontFamily(
            Font(R.font.mbc_1961_m),
            Font(R.font.mbc_1961_gulim_m),
            Font(R.font.nanum_square_neo_1),
            Font(R.font.nanum_square_neo_2),
            Font(R.font.nanum_square_neo_3),
            Font(R.font.nanum_square_neo_4),
            Font(R.font.nanum_square_neo_5)
        )


        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = {
                    bottomNavigationBar()
                },
                topBar = {
                    topAppBar()
                },
                floatingActionButton = {
                    floatingButton()
                }

            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    statusBar()
                    Text(
                        text = "뉴스 기사 요약을 시작해보세요 :)",
                        color = Color.Black,
                        fontFamily = fontFamily,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(top = 25.dp)
                    )


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
    /*var selectedItem by remember { mutableStateOf(0) }
    val items = remember {
        listOf("집중력향상법", "홈", "설정")
    }*/
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 10.dp)
                .background(color = Color(0xFFF3F4FF))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()
                    .background(color = Color(0xFFF3F4FF)),
                contentAlignment = Alignment.Center
            ) {
                Column() {
                    Image(
                        painter = painterResource(id = R.drawable.btn_bottom_nv_1),
                        contentDescription = "집중력 향상 방법",
                        modifier = Modifier
                            .size(120.dp)
                            .padding(end = 20.dp)
                    )
                }


            }
            Box(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight()
                    .background(color = Color(0xFFF3F4FF)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.btn_bottom_nv_3),
                    contentDescription = "설정",
                    modifier = Modifier
                        .size(48.dp)
                        .padding(start = 20.dp)
                )

            }
        }
        Image(
            painter = painterResource(id = R.drawable.btn_bottom_nv_2),
            contentDescription = "홈",
            modifier = Modifier.size(100.dp),
            alignment = Alignment.TopCenter
        )

    }


}

@Composable
fun statusBar() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()

    DisposableEffect(systemUiController, useDarkIcons) {
        // Update all of the system bar colors to be transparent, and use
        // dark icons if we're in light theme
        systemUiController.setSystemBarsColor(
            color = Color(0xFFF3F4FF),
            darkIcons = useDarkIcons
        )

        // setStatusBarColor() and setNavigationBarColor() also exist

        onDispose {}
    }
}

@Composable
fun floatingButton() {
    val contextForToast = LocalContext.current.applicationContext

    Box(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            modifier = Modifier
                .padding(all = 10.dp)
                .align(alignment = Alignment.BottomEnd),
            onClick = {
                Toast.makeText(contextForToast, "Click", Toast.LENGTH_SHORT)
                    .show()
            },
            backgroundColor = Color(0xFFD4D6FF)
        ) {
            //Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
            Image(
                painter = painterResource(id = R.drawable.ftbtn_search),
                contentDescription = "단어 찾기",
                modifier = Modifier.size(48.dp)
            )
        }
    }


}