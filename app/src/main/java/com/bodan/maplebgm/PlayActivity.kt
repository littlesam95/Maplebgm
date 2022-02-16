package com.bodan.maplebgm

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bodan.maplebgm.databinding.ActivityPlayBinding

class PlayActivity : AppCompatActivity() {
    private var mBinding : ActivityPlayBinding? = null
    private val binding get() = mBinding!!

    lateinit var mp3List : ArrayList<String>
    lateinit var selectedMp3 : String
    lateinit var mPlayer : MediaPlayer



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (intent.hasExtra("idText")) {
            val id = intent.getStringExtra("idText")
            Toast.makeText(applicationContext, id + "님 환영합니다!", Toast.LENGTH_LONG).show()
        }

        mPlayer = MediaPlayer.create(this, R.raw.abovethetreetops)
        mPlayer.start()
    }
}