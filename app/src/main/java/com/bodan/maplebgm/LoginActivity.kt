package com.bodan.maplebgm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.bodan.maplebgm.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    // 뷰 바인딩
    private var mBinding : ActivityLoginBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 뷰 바인딩
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toast = Toast.makeText(applicationContext, "별명을 입력해주세요!", Toast.LENGTH_SHORT)
        toast.show()

        binding.generateButton.setOnClickListener {
            var idText = binding.idText.text.toString()
            val intent = Intent(this@LoginActivity, PlayActivity::class.java)
            intent.putExtra("idText", idText)
            toast.cancel()
            startActivity(intent) // intent를 사용하여 PlayActivity 시작
        }
    }
}