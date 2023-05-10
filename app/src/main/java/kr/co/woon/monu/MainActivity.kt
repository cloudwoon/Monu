package kr.co.woon.monu

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableOpenTarget
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

val fontFamily = FontFamily(
    Font(R.font.mbc_1961_m),
    Font(R.font.mbc_1961_gulim_m),
    Font(R.font.nanum_square_neo_1),
    Font(R.font.nanum_square_neo_2),
    Font(R.font.nanum_square_neo_3),
    Font(R.font.nanum_square_neo_4),
    Font(R.font.nanum_square_neo_5)
)

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)


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

                statusBar()
                homeScreen()

                //settingScreen()

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
    val context = LocalContext.current.applicationContext

    Box(modifier = Modifier.fillMaxSize()) {
        FloatingActionButton(
            modifier = Modifier
                .padding(all = 10.dp)
                .align(alignment = Alignment.BottomEnd),
            onClick = {
                val intent = Intent(
                    context,
                    SearchActivity::class.java
                ).addFlags(FLAG_ACTIVITY_NEW_TASK) //화면 전환
                context.startActivity(intent)
            },
            backgroundColor = Color(0xFFD4D6FF)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ftbtn_search),
                contentDescription = "단어 검색",
                modifier = Modifier.size(48.dp)

            )
        }
    }


}

@Composable
fun KotlinWorldButtonWithDropDownMenu() {

    val contextForToast = LocalContext.current.applicationContext


    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopEnd
    ) {
        // 1. DropDownMenu의 펼쳐짐 상태 정의
        var isDropDownMenuExpanded by remember { mutableStateOf(false) }

        // 2. DropDownMenu의 Expanded 상태를 변경하기 위한 버튼 정의
        Button(
            onClick = { isDropDownMenuExpanded = true },
            modifier = Modifier
                .padding(end = 20.dp, top = 30.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFF7B80FD),
                    shape = RectangleShape
                )
                .background(color = Color(0xFFD8D9FF)),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFD8D9FF),
                contentColor = Color.White
            ),
            shape = RectangleShape,
            elevation = ButtonDefaults.elevation(0.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "요약 문장 수", fontSize = 16.sp)
                Image(
                    painter = painterResource(id = R.drawable.ic_dropdown),
                    contentDescription = "dropdown",
                    modifier = Modifier.size(14.dp)
                )
            }
        }
        //3. DropDownMenu 정의
        DropdownMenu(
            modifier = Modifier
                .wrapContentSize(),
            expanded = isDropDownMenuExpanded,
            onDismissRequest = { isDropDownMenuExpanded = false },

            ) {
            // 3.1. DropDownMenuItem을 정의하고 눌렸을 때 Hello가 출력되도록 함
            DropdownMenuItem(onClick = {
                Toast.makeText(contextForToast, "1", Toast.LENGTH_SHORT)
                    .show()
            }) {
                Text(text = "1")


            }
            // 3.2. DropDownMenuItem을 정의하고 눌렸을 때 KotlinWorld가 출력되도록 함
            DropdownMenuItem(onClick = {
                Toast.makeText(contextForToast, "2", Toast.LENGTH_SHORT)
                    .show()
            }) {
                Text(text = "2")

            }

            // 3.3. DropDownMenuItem을 정의하고 눌렸을 때 KotlinWorld가 출력되도록 함
            DropdownMenuItem(onClick = {
                Toast.makeText(contextForToast, "3", Toast.LENGTH_SHORT)
                    .show()
            }) {
                Text(text = "3")

            }
        }
    }
}

@Composable
fun initialTitle() {

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopStart
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_main_title_1),
            contentDescription = "원문 타이틀",
            modifier = Modifier
                .size(width = 250.dp, height = 40.dp)
                .padding(start = 20.dp)
        )
    }
}


@Composable
fun initialText() {
    val contextForToast = LocalContext.current.applicationContext

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(top = 10.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(2.dp, Color(0xFFBBBEFE)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                backgroundColor = Color(0xFFFAFAFF)
            ) {
                var text by remember { mutableStateOf("") }
                var scrollState = rememberScrollState()


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                        .verticalScroll(scrollState)
                ) {

                    Text(text = "$text")

                    BasicTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        value = text,
                        onValueChange = { text = it },
                        decorationBox = {},
                    )
                }


            }

            Button(
                onClick = {
                    Toast.makeText(contextForToast, "요약하기 실행", Toast.LENGTH_SHORT)
                        .show()
                },
                modifier = Modifier
                    .wrapContentSize()
                    .padding(top = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFD8D9FF),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(size = 20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "요약하기", color = Color(0xFF7B80FD), fontSize = 16.sp)
                    Image(
                        painter = painterResource(id = R.drawable.ic_summarize),
                        contentDescription = "요약하기 이모티콘",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(start = 10.dp, top = 6.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun afterTitle() {

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopStart
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_main_title_2),
            contentDescription = "원문 타이틀",
            modifier = Modifier
                .size(width = 250.dp, height = 30.dp)
                .padding(start = 20.dp)
        )
    }
}

@Composable
fun afterText() {
    val contextForToast = LocalContext.current.applicationContext

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .padding(horizontal = 20.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(2.dp, Color(0xFFBBBEFE)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                backgroundColor = Color(0xFFFAFAFF)
            ) {
                var scrollState = rememberScrollState()
                var output = "결과출력"

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(5.dp)
                        .verticalScroll(scrollState)
                ) {
                    Text(text = "$output", color = Color.Black, fontSize = 16.sp)
                }
            }
        }
    }
}


@Composable
fun homeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,

            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "뉴스 기사 요약을 시작해보세요 :)",
                color = Color.Black,
                fontFamily = fontFamily,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 25.dp)
            )
            KotlinWorldButtonWithDropDownMenu()
            initialTitle()
            initialText()
            afterTitle()
            afterText()
        }


    }
}

@Composable
fun settingScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFFFF)),
        contentAlignment = Alignment.TopCenter
    ) {

        Image(
            painter = painterResource(id = R.drawable.bg_setting),
            contentDescription = "세팅화면",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

    }

}


