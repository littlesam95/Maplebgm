package com.bodan.maplebgm

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.bodan.maplebgm.databinding.ActivityFinishBinding

class FinishActivity : AppCompatActivity() {
    // 뷰 바인딩
    private var mBinding : ActivityFinishBinding? = null
    private val binding get() = mBinding!!
    var finalScore : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 뷰 바인딩
        mBinding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("score")) {
            finalScore = intent.getIntExtra("score", 0)
        }
        Toast.makeText(applicationContext, "게임이 종료되었습니다.", Toast.LENGTH_SHORT).show()

        if (finalScore == 0) {
            binding.score.setImageResource(R.drawable.zero)
        }
        else if (finalScore == 1) {
            binding.score.setImageResource(R.drawable.one)
        }
        else if (finalScore == 2) {
            binding.score.setImageResource(R.drawable.two)
        }
        else if (finalScore == 3) {
            binding.score.setImageResource(R.drawable.three)
        }
        else if (finalScore == 4) {
            binding.score.setImageResource(R.drawable.four)
        }
        else if (finalScore == 5) {
            binding.score.setImageResource(R.drawable.five)
        }
        else if (finalScore == 6) {
            binding.score.setImageResource(R.drawable.six)
        }
        else if (finalScore == 7) {
            binding.score.setImageResource(R.drawable.seven)
        }
        else if (finalScore == 8) {
            binding.score.setImageResource(R.drawable.eight)
        }
        else if (finalScore == 9) {
            binding.score.setImageResource(R.drawable.nine)
        }
        else if (finalScore == 10) {
            binding.score.setImageResource(R.drawable.ten)
        }
        else if (finalScore == 11) {
            binding.score.setImageResource(R.drawable.eleven)
        }
        else if (finalScore == 12) {
            binding.score.setImageResource(R.drawable.twelve)
        }
        else if (finalScore == 13) {
            binding.score.setImageResource(R.drawable.thirteen)
        }
        else if (finalScore == 14) {
            binding.score.setImageResource(R.drawable.fourteen)
        }
        else if (finalScore == 15) {
            binding.score.setImageResource(R.drawable.fifteen)
        }
        else if (finalScore == 16) {
            binding.score.setImageResource(R.drawable.sixteen)
        }
        else if (finalScore == 17) {
            binding.score.setImageResource(R.drawable.seventeen)
        }
        else if (finalScore == 18) {
            binding.score.setImageResource(R.drawable.eighteen)
        }
        else if (finalScore == 19) {
            binding.score.setImageResource(R.drawable.nineteen)
        }
        else if (finalScore == 20) {
            binding.score.setImageResource(R.drawable.twenty)
        }
        else if (finalScore == 21) {
            binding.score.setImageResource(R.drawable.twentyone)
        }
        else if (finalScore == 22) {
            binding.score.setImageResource(R.drawable.twentytwo)
        }
        else if (finalScore == 23) {
            binding.score.setImageResource(R.drawable.twentythree)
        }
        else if (finalScore == 24) {
            binding.score.setImageResource(R.drawable.twentyfour)
        }
        else if (finalScore == 25) {
            binding.score.setImageResource(R.drawable.twentyfive)
        }
        else if (finalScore == 26) {
            binding.score.setImageResource(R.drawable.twentysix)
        }
        else if (finalScore == 27) {
            binding.score.setImageResource(R.drawable.twentyseven)
        }
        else if (finalScore == 28) {
            binding.score.setImageResource(R.drawable.twentyeight)
        }
        else if (finalScore == 29) {
            binding.score.setImageResource(R.drawable.twentynine)
        }
        else if (finalScore == 30) {
            binding.score.setImageResource(R.drawable.thirty)
        }

        // 메인 화면으로 돌아가기
        binding.returnButton.setOnClickListener {
            val intent = Intent(this@FinishActivity, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) // 실행할 activity가 이미 스택에 존재하면 해당 activity 위에 존재하는 다른 activity 모두 종료시킨다.
            startActivity(intent)
            finish()
        }

        // 앱 종료
        binding.exitButton.setOnClickListener {
            ActivityCompat.finishAffinity(this)
            System.exit(0);
        }

        // 제작자놈 블로그로 이동
       binding.blogButton.setOnClickListener {
           val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://littlesam95.tistory.com/188"))
           startActivity(intent)
        }
    }

    override fun onBackPressed() {
        // super.onBackPressed()
    }
}