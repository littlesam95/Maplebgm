package com.bodan.maplebgm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class PlayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        Toast.makeText(applicationContext, "게임 시작", Toast.LENGTH_LONG).show()
    }
}