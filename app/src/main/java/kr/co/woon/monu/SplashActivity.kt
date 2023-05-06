package kr.co.woon.monu

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource


class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()

        val handler = Handler()

        handler.postDelayed(Runnable {
            val intent = Intent(this@SplashActivity, MainActivity::class.java) //화면 전환
            startActivity(intent)
            finish()
        }, 2000) //딜레이 타임 조절

        setContent {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_splash_screen),
                    contentDescription = "스플래시 화면",
                    contentScale = ContentScale.Crop
                )
            }
        }

    }

}