package com.bodan.maplebgm

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bodan.maplebgm.databinding.ActivityPlayBinding

class PlayActivity : AppCompatActivity() {
    private var toast : Toast? = null
    private var mBinding : ActivityPlayBinding? = null
    private val binding get() = mBinding!!

    var pos = 0
    var nameArray = arrayOf("로그인", "리스항구", "헤네시스필드", "엘리니아", "페리온", "커닝시티", "헤네시스", "오르비스", "엘나스", "루디브리엄", "아리안트", "마가티아", "에레브", "에레브연무장")
    var nameEngArray = arrayOf("Title", "Above the Treetops", "Rest N Peace", "When the Morning Comes", "Nightmare", "Bad Guys", "Floral Life", "Shinin' Harbor", "Snowy Village", "Fantastic Thinking", "Ariant", "Dispute", "Queen's Garden", "Drill Hall")

    private lateinit var mPlayer : MediaPlayer
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (intent.hasExtra("idText")) {
            val id = intent.getStringExtra("idText")
            toast?.cancel()
            toast = Toast.makeText(applicationContext, id + "님 환영합니다!", Toast.LENGTH_SHORT)
            toast?.show()
        }

        binding.bgmplayButton.setOnClickListener {
            pos = (Math.random() * 14).toInt()
            if (pos == 0) {
                mPlayer = MediaPlayer.create(this, R.raw.title)
            }
            else if (pos == 1) {
                mPlayer = MediaPlayer.create(this, R.raw.abovethetreetops)
            }
            else if (pos == 2) {
                mPlayer = MediaPlayer.create(this, R.raw.restnpeace)
            }
            else if (pos == 3) {
                mPlayer = MediaPlayer.create(this, R.raw.whenthemorningcomes)
            }
            else if (pos == 4) {
                mPlayer = MediaPlayer.create(this, R.raw.nightmare)
            }
            else if (pos == 5) {
                mPlayer = MediaPlayer.create(this, R.raw.badguys)
            }
            else if (pos == 6) {
                mPlayer = MediaPlayer.create(this, R.raw.florallife)
            }
            else if (pos == 7) {
                mPlayer = MediaPlayer.create(this, R.raw.shininharbor)
            }
            else if (pos == 8) {
                mPlayer = MediaPlayer.create(this, R.raw.snowyvilage)
            }
            else if (pos == 9) {
                mPlayer = MediaPlayer.create(this, R.raw.fantasticthinking)
            }
            else if (pos == 10) {
                mPlayer = MediaPlayer.create(this, R.raw.ariant)
            }
            else if (pos == 11) {
                mPlayer = MediaPlayer.create(this, R.raw.dispute)
            }
            else if (pos == 12) {
                mPlayer = MediaPlayer.create(this, R.raw.queensgarden)
            }
            else if (pos == 13) {
                mPlayer = MediaPlayer.create(this, R.raw.drillhall)
            }
            mPlayer.start()
        }
        binding.answerButton.setOnClickListener {
            var answerText = binding.answerText.text.toString()
            if ((answerText == nameArray[pos]) || (answerText == nameEngArray[pos])) {
                score = score + 1
                toast = Toast.makeText(applicationContext, "정답입니다!", Toast.LENGTH_SHORT)
                toast?.show()
            }
            toast?.cancel()
            toast = Toast.makeText(applicationContext, "현재 점수는 " + score + "점입니다.", Toast.LENGTH_SHORT)
            toast?.show()
            mPlayer.stop()
        }
    }
}