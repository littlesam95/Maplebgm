package com.bodan.maplebgm

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bodan.maplebgm.databinding.ActivityPlayBinding

class PlayActivity : AppCompatActivity() {
    private var mBinding : ActivityPlayBinding? = null
    private val binding get() = mBinding!!

    private lateinit var mPlayer : MediaPlayer
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (intent.hasExtra("idText")) {
            val id = intent.getStringExtra("idText")
            Toast.makeText(applicationContext, id + "님 환영합니다!", Toast.LENGTH_LONG).show()
        }

        mPlayer = MediaPlayer.create(this, R.raw.abovethetreetops)
        binding.bgmplayButton.setOnClickListener {
            mPlayer.start()
        }
        binding.answerButton.setOnClickListener {
            var answerText = binding.answerText.text.toString()
            score = score + 1
            Toast.makeText(applicationContext, "정답입니다! 현재 점수는 " + score + "점입니다.", Toast.LENGTH_LONG).show()
            mPlayer.stop()
            mPlayer = MediaPlayer.create(this, R.raw.restnpeace)
        }
    }
}