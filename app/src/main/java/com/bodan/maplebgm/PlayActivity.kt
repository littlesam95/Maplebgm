package com.bodan.maplebgm

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bodan.maplebgm.databinding.ActivityPlayBinding

class PlayActivity : AppCompatActivity() {
    private var mBinding : ActivityPlayBinding? = null
    private val binding get() = mBinding!!

    private var mPlayer : MediaPlayer? = null

    var bgm = arrayOf(R.raw.heroes5, R.raw.abovethetreetops, R.raw.restnpeace)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (intent.hasExtra("idText")) {
            val id = intent.getStringExtra("idText")
            Toast.makeText(applicationContext, id + "님 환영합니다!", Toast.LENGTH_LONG).show()
        }
        var play : Int = 0
        while (play < 3) {
            mPlayer = MediaPlayer.create(this, bgm[play])
            mPlayer?.start()
            mPlayer = null
            if(mPlayer?.isPlaying == false){
                play = play + 1;
            }
        }
    }
}