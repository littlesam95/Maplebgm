package com.bodan.maplebgm

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bodan.maplebgm.databinding.ActivityPlayBinding

class PlayActivity : AppCompatActivity() {
    private var toast : Toast? = null
    private var mBinding : ActivityPlayBinding? = null
    private val binding get() = mBinding!!

    var on = 0
    var pos = 0
    var message = ""
    var nameArray = arrayOf("로그인", "리스항구", "헤네시스필드", "엘리니아", "페리온", "커닝시티", "헤네시스",
        "오르비스", "엘나스", "루디브리엄", "아리안트", "마가티아", "에레브", "에레브연무장", "노틸러스선착장", "노틸러스",
        "슬리피우드", "엘리니아나무던전", "엘리니아필드", "커닝시티늪지대", "불타버린땅", "비화원", "개미굴",
        "커닝시티지하철", "블러디퀸", "피에르", "반반", "벨룸")
    var nameEngArray = arrayOf("Title", "Above the Treetops", "Rest N Peace", "When the Morning Comes", "Nightmare",
        "Bad Guys", "Floral Life", "Shinin' Harbor", "Snowy Village", "Fantastic Thinking", "Ariant", "Dispute",
        "Queen's Garden", "Drill Hall", "Nautilus", "in Nautilus", "Sleepy Wood", "Missing You", "Moonlight Shadow",
        "Jungle Book", "Highland Star", "Secret Flower", "Ancient Move", "Subway", "Queen's Palace", "Joyful Tea Party",
        "Tiem Chaos", "Abyss Cave")

    private lateinit var mPlayer : MediaPlayer
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (intent.hasExtra("idText")) {
            val id = intent.getStringExtra("idText")
            toast?.cancel()
            Toast.makeText(applicationContext, id + "님 환영합니다!", Toast.LENGTH_SHORT).show()
        }

        binding.helpButton.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.custon_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)

            val mAlertDialog = mBuilder.show()

            val closeButton = mDialogView.findViewById<ImageButton>(R.id.closeButton)
            closeButton.setOnClickListener {
                mAlertDialog.dismiss()
            }
        }

        binding.bgmplayButton.setOnClickListener {
            if (on == 0) {
                pos = (Math.random() * 28).toInt()
                if (pos == 0) {
                    mPlayer = MediaPlayer.create(this, R.raw.title)
                } else if (pos == 1) {
                    mPlayer = MediaPlayer.create(this, R.raw.abovethetreetops)
                } else if (pos == 2) {
                    mPlayer = MediaPlayer.create(this, R.raw.restnpeace)
                } else if (pos == 3) {
                    mPlayer = MediaPlayer.create(this, R.raw.whenthemorningcomes)
                } else if (pos == 4) {
                    mPlayer = MediaPlayer.create(this, R.raw.nightmare)
                } else if (pos == 5) {
                    mPlayer = MediaPlayer.create(this, R.raw.badguys)
                } else if (pos == 6) {
                    mPlayer = MediaPlayer.create(this, R.raw.florallife)
                } else if (pos == 7) {
                    mPlayer = MediaPlayer.create(this, R.raw.shininharbor)
                } else if (pos == 8) {
                    mPlayer = MediaPlayer.create(this, R.raw.snowyvilage)
                } else if (pos == 9) {
                    mPlayer = MediaPlayer.create(this, R.raw.fantasticthinking)
                } else if (pos == 10) {
                    mPlayer = MediaPlayer.create(this, R.raw.ariant)
                } else if (pos == 11) {
                    mPlayer = MediaPlayer.create(this, R.raw.dispute)
                } else if (pos == 12) {
                    mPlayer = MediaPlayer.create(this, R.raw.queensgarden)
                } else if (pos == 13) {
                    mPlayer = MediaPlayer.create(this, R.raw.drillhall)
                } else if (pos == 14) {
                    mPlayer = MediaPlayer.create(this, R.raw.nautilus)
                } else if (pos == 15) {
                    mPlayer = MediaPlayer.create(this, R.raw.innautilus)
                } else if (pos == 16) {
                    mPlayer = MediaPlayer.create(this, R.raw.sleepywood)
                } else if (pos == 17) {
                    mPlayer = MediaPlayer.create(this, R.raw.missingyou)
                } else if (pos == 18) {
                    mPlayer = MediaPlayer.create(this, R.raw.moonlightshadow)
                } else if (pos == 19) {
                    mPlayer = MediaPlayer.create(this, R.raw.junglebook)
                } else if (pos == 20) {
                    mPlayer = MediaPlayer.create(this, R.raw.highlandstar)
                } else if (pos == 21) {
                    mPlayer = MediaPlayer.create(this, R.raw.secretflower)
                } else if (pos == 22) {
                    mPlayer = MediaPlayer.create(this, R.raw.ancientmove)
                } else if (pos == 23) {
                    mPlayer = MediaPlayer.create(this, R.raw.subway)
                } else if (pos == 24) {
                    mPlayer = MediaPlayer.create(this, R.raw.queenspalace)
                } else if (pos == 25) {
                    mPlayer = MediaPlayer.create(this, R.raw.joyfulteaparty)
                } else if (pos == 26) {
                    mPlayer = MediaPlayer.create(this, R.raw.timechaos)
                } else if (pos == 27) {
                    mPlayer = MediaPlayer.create(this, R.raw.abysscave)
                }
                mPlayer.start()
                on = 1
            }
            else if (on == 1) {
                Toast.makeText(applicationContext, "음악이 이미 실행 중입니다.", Toast.LENGTH_SHORT).show()
            }
        }
        binding.answerButton.setOnClickListener {
            if (on == 0) {
                Toast.makeText(applicationContext, "음악이 실행 중이 아닙니다.", Toast.LENGTH_SHORT).show()
            }
            else if (on == 1) {
                var answerText = binding.answerText.text.toString()
                if ((answerText == nameArray[pos]) || (answerText == nameEngArray[pos])) {
                    score = score + 1
                    message += "정답입니다!"
                }
                Toast.makeText(applicationContext, message + "현재 점수는 " + score + "점입니다.", Toast.LENGTH_SHORT).show()
                mPlayer.stop()
                on = 0
                message = ""
            }
        }
    }
}