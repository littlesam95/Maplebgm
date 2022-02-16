package com.bodan.maplebgm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.bodan.maplebgm.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private var mBinding : ActivityLoginBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Toast.makeText(applicationContext, "별명을 입력해주세요!", Toast.LENGTH_LONG).show()

        binding.generateButton.setOnClickListener {
            var idText = binding.idText.text.toString()

            val intent = Intent(this@LoginActivity, PlayActivity::class.java)
            intent.putExtra("idText", idText)
            startActivity(intent) // intent를 사용하여 PlayActivity 시작
        }
    }
}