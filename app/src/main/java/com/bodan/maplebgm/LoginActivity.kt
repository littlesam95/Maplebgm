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
    var helper: RoomHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 뷰 바인딩
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toast = Toast.makeText(applicationContext, "별명을 입력해주세요!", Toast.LENGTH_SHORT)
        toast.show()

        helper = Room.databaseBuilder(this,RoomHelper::class.java, "room_memo")
            .allowMainThreadQueries()
            .build()

        binding.generateButton.setOnClickListener {
            var idText = binding.idText.text.toString()

            val memo1 = RoomMemo("abovethetreetops", "리스항구", "리스항구")
            helper?.roomMemoDao()?.insert(memo1)
            val memo3 = RoomMemo("restnpeace", "헤네시스필드", "헤네시스동쪽풀숲")
            helper?.roomMemoDao()?.insert(memo3)

            val intent = Intent(this@LoginActivity, PlayActivity::class.java)
            intent.putExtra("idText", idText)
            toast.cancel()
            startActivity(intent) // intent를 사용하여 PlayActivity 시작
        }
    }
}