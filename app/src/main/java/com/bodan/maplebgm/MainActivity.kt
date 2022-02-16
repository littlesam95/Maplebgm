package com.bodan.maplebgm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext, "환영합니다..", Toast.LENGTH_LONG).show()

        findViewById<View>(R.id.startButton).setOnClickListener {
            // LoginActivity를 시작하는 Intent를 생성
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent) // intent를 사용하여 LoginActivity 시작
        }
    }
}