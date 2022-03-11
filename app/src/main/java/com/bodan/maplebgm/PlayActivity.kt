package com.bodan.maplebgm

import android.content.Intent
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
        "커닝시티지하철", "블러디퀸", "피에르", "반반", "벨룸", "수련의숲", "리엔", "뒤틀린시간의길1,2", "뒤틀린시간의길3,4",
        "잊혀진시간의길1,2", "잊혀진시간의길3,4", "지구방위본부", "힐라", "무릉", "백초마을", "리프레", "켄타우로스의영역",
        "혼테일", "시간의신전", "추억의길", "후회의길", "망각의길", "핑크빈", "아쿠아리움", "피아누스", "베리타스", "쿨란초원",
        "로스웰초원", "카웅", "거울세계리프레", "거울세계아리안트", "거울세계헤네시스", "거울세계무릉도원", "거울세계에델슈타인",
        "거울세계마가티아", "거울세계루디브리엄", "거울세계시간의신전", "망각의호수", "소멸의화염지대", "안식의동굴", "츄츄빌리지",
        "에르밸리", "꿈의도시레헬른", "루시드1페", "루시드2페", "악몽의시계탑", "신비의숲아르카나", "스피릿세이비어", "트뤼에페광장",
        "그림자가춤추는곳", "생명이시작되는곳", "거울빛에물든바다", "거울에비친빛의신전", "윌1페", "윌2페", "윌3페", "전초기지",
        "사상의경계", "미지의안개", "공허의파도", "거대괴수더스크", "고통의미궁내부", "고통의미궁중심부", "고통의미궁최심부",
        "진힐라" ,"세계의눈물", "세계가끝나는곳", "듄켈", "검마1페", "검마2페", "검마3페", "검마4페", "세렌1페", "세렌2페정오",
        "세렌2페석양", "세렌2페자정", "세렌2페여명")
    var nameArraySecond = arrayOf("타이틀", " ", "골렘의사원", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "연무장",
        " ", " ", " ", "나무던전", "솟아오른나무", "늪지대", " ", " ", " ", "지하철", "블퀸", "삐에로", " ", " ", "에레브수련의숲",
        " ", " ", " ", " ", " ", "지방본", " ", "무릉도원", " ", " ", "켄타우로스", " ", " ", "추길", "후길", "망길", " ", " ",
        " ", " ", " ", " ", " ", "(거울세계)리프레", "(거울세계)아리안트", "(거울세계)헤네시스", "(거울세계)무릉도원", "(거울세계)에델슈타인",
        "(거울세계)마가티아", "(거울세계)루디브리엄", "(거울세계)시간의신전", "소멸의여로", "화염지대", "동아", "츄츄아일랜드", "격류지대", "레헬른", "몽환의숲",
        "무너지는시계탑", "시계탑", "아르카나", "스세", "기억의늪모라스", "그춤", "생시", "거물바", "신전", "회절의회랑", "깊은거울", "바스러지는빛",
        " ", "사경", "미안", "공파", "더스크", "미궁내부", "중심부", "최심부", "욕망의제단" ,"눈물", "세끝", "끝에가까운곳", "어둠의신전", "어둠의왕좌",
        "시작과끝의경계", "존재하지않는공간", "왕궁메인홀", "세렌정오", "세렌석양", "세렌자정", "세렌여명")
    var nameArrayThird = arrayOf(" ", " ", "헤네시스북쪽언덕", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
        " ", " ", " ", "방황의늪", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
        " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "[거울세계]리프레", "[거울세계]아리안트", "[거울세계]헤네시스",
        "[거울세계]무릉도원", "[거울세계]에델슈타인", "[거울세계]마가티아", "[거울세계]루디브리엄", "[거울세계]시간의신전", "여로", " ", "여로동아", "츄츄",
        " ", "레헬", " ", " ", " ", "알카", " ", "모라스", "폐쇄구역", "생명", " ", " ", " ", " ", " ", " ", "사상", "미지", "파도", " ",
        "내부", "미중", "미최", " " ," ", " ", " ", " ", " ", " ", " ", " ", "정오", "석양", "자정", "여명")
    var nameArrayFourth = arrayOf(" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
        "위험한크로코", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
        " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
        " ", " ", " ", " ", " ", "폐쇄", " ", " ", " ", " ", " ", " ", " ", " ", "안개", " ", " ", " ", " ", " ", " " ," ", " ", " ", " ",
        " ", " ", " ", " ", " ", " ", " ", " ")
    var nameEngArray = arrayOf("Title", "Above the Treetops", "Rest N Peace", "When the Morning Comes", "Nightmare",
        "Bad Guys", "Floral Life", "Shinin' Harbor", "Snowy Village", "Fantastic Thinking", "Ariant", "Dispute",
        "Queen's Garden", "Drill Hall", "Nautilus", "Interior of Nautilus", "Sleepywood", "Missing You", "Moonlight Shadow",
        "Jungle Book", "Highland Star", "Secret Flower", "Ancient Move", "Subway", "Queen Palace", "Joyful Tea Party",
        "Time Chaos", "Abyss Cave", "The Raindrop Flower", "Rien Village", "Fairytale", "Fairytale Diffver", "Timeless A",
        "Timeless B", "Let's March", "Red Witch", "Mu Lung Hill", "White Herb", "Leafre", "Acient Forest", "HonTale",
        "Time Temple", "Remembrance", "Repentance", "Forgetfulness", "Fighting Pinkbeen", "Aquarium", "Aqua Cave", "In All Verity",
        "Finding Forest", "Let's Hunt Alien", "Vacuum Cleaner", "Leafre in Mirror", "Ariant in Mirror", "Floral Life in Mirror",
        "Mureung Hill in Mirror", "Edelstein City in Mirror", "Dispute in Mirror", "Fantastic Thinking in Mirror", "Time Temple in Mirror",
        "The Lake of Oblivion", "The Volcanic Mountain", "The Cave of Peace", "Expedition to ChewChew Island", "Welcome to ChewChew",
        "Lacheln, The City of Dreams", "The Phantasmal Woods", "The Dream Fragments", "The Shattered Time", "The Tune of Azure Light",
        "Shadow of incongruity", "Memory of Kritias", "Black Dungeon", "A Place Where Life Begins", "Contaminated Sea", "Le Temple du Miroir",
        "Diffraction", "Mirrored Cage", "The Bloody Cage", "Outpost", "War Cloud", "Strange Fog", "Wave of Emptiness", "Ferocious Battlefield",
        "Secret Labyrinth", "Eternal Swamp", "Heart of Suffering", "Depth of Pain", "Tears of the world", "The World's End", "Subterminal Point",
        "Temple of Darkness", "Throne of Darkness", "World Horizon", "Lost Space", "Awakening Of Old God", "Solar Deity - Noon of Justice",
        "Solar Deity - Twilight of Flame", "Solar Deity - Midnight of Silence", "Solar Deity - Dawn of Hope")

    var countArray = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, )

    private lateinit var mPlayer : MediaPlayer
    private var score : Int = 0
    private var count : Int = 0

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
            if (count < 30) {
                if (on == 0) {
                    while (true) {
                        pos = (Math.random() * 100).toInt()
                        if (countArray[pos] == 0) {
                            break
                        }
                    }
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
                    } else if (pos == 28) {
                        mPlayer = MediaPlayer.create(this, R.raw.raindropflower)
                    } else if (pos == 29) {
                        mPlayer = MediaPlayer.create(this, R.raw.rienvillage)
                    } else if (pos == 30) {
                        mPlayer = MediaPlayer.create(this, R.raw.fairytale)
                    } else if (pos == 31) {
                        mPlayer = MediaPlayer.create(this, R.raw.fairytalediffver)
                    } else if (pos == 32) {
                        mPlayer = MediaPlayer.create(this, R.raw.timeless)
                    } else if (pos == 33) {
                        mPlayer = MediaPlayer.create(this, R.raw.timelessb)
                    } else if (pos == 34) {
                        mPlayer = MediaPlayer.create(this, R.raw.letsmarch)
                    } else if (pos == 35) {
                        mPlayer = MediaPlayer.create(this, R.raw.redwitch)
                    } else if (pos == 36) {
                        mPlayer = MediaPlayer.create(this, R.raw.mulunghill)
                    } else if (pos == 37) {
                        mPlayer = MediaPlayer.create(this, R.raw.whiteherb)
                    } else if (pos == 38) {
                        mPlayer = MediaPlayer.create(this, R.raw.leafre)
                    } else if (pos == 39) {
                        mPlayer = MediaPlayer.create(this, R.raw.acientforest)
                    } else if (pos == 40) {
                        mPlayer = MediaPlayer.create(this, R.raw.hontale)
                    } else if (pos == 41) {
                        mPlayer = MediaPlayer.create(this, R.raw.timetemple)
                    } else if (pos == 42) {
                        mPlayer = MediaPlayer.create(this, R.raw.remembrance)
                    } else if (pos == 43) {
                        mPlayer = MediaPlayer.create(this, R.raw.repentance)
                    } else if (pos == 44) {
                        mPlayer = MediaPlayer.create(this, R.raw.forgetfulness)
                    } else if (pos == 45) {
                        mPlayer = MediaPlayer.create(this, R.raw.fightingpinkbeen)
                    } else if (pos == 46) {
                        mPlayer = MediaPlayer.create(this, R.raw.aquarium)
                    } else if (pos == 47) {
                        mPlayer = MediaPlayer.create(this, R.raw.aquacave)
                    } else if (pos == 48) {
                        mPlayer = MediaPlayer.create(this, R.raw.inallverity)
                    } else if (pos == 49) {
                        mPlayer = MediaPlayer.create(this, R.raw.findingforest)
                    } else if (pos == 50) {
                        mPlayer = MediaPlayer.create(this, R.raw.letshuntaliens)
                    } else if (pos == 51) {
                        mPlayer = MediaPlayer.create(this, R.raw.vacuumcleaner)
                    } else if (pos == 52) {
                        mPlayer = MediaPlayer.create(this, R.raw.leafreinmirror)
                    } else if (pos == 53) {
                        mPlayer = MediaPlayer.create(this, R.raw.ariantinmirror)
                    } else if (pos == 54) {
                        mPlayer = MediaPlayer.create(this, R.raw.florallifeinmirror)
                    } else if (pos == 55) {
                        mPlayer = MediaPlayer.create(this, R.raw.mureunghillinmirror)
                    } else if (pos == 56) {
                        mPlayer = MediaPlayer.create(this, R.raw.edelsteincityinmirror)
                    } else if (pos == 57) {
                        mPlayer = MediaPlayer.create(this, R.raw.disputeinmirror)
                    } else if (pos == 58) {
                        mPlayer = MediaPlayer.create(this, R.raw.fantasticthinkinginmirror)
                    } else if (pos == 59) {
                        mPlayer = MediaPlayer.create(this, R.raw.timetempleinmirror)
                    } else if (pos == 60) {
                        mPlayer = MediaPlayer.create(this, R.raw.lakeofoblivion)
                    } else if (pos == 61) {
                        mPlayer = MediaPlayer.create(this, R.raw.volcanicmountain)
                    } else if (pos == 62) {
                        mPlayer = MediaPlayer.create(this, R.raw.caveofpeace)
                    } else if (pos == 63) {
                        mPlayer = MediaPlayer.create(this, R.raw.expeditiontochewchewisland)
                    } else if (pos == 64) {
                        mPlayer = MediaPlayer.create(this, R.raw.welcometochewchew)
                    } else if (pos == 65) {
                        mPlayer = MediaPlayer.create(this, R.raw.lachlnthecityofdreams)
                    } else if (pos == 66) {
                        mPlayer = MediaPlayer.create(this, R.raw.thephantasmalwoods)
                    } else if (pos == 67) {
                        mPlayer = MediaPlayer.create(this, R.raw.dreamfragments)
                    } else if (pos == 68) {
                        mPlayer = MediaPlayer.create(this, R.raw.shatteredtime)
                    } else if (pos == 69) {
                        mPlayer = MediaPlayer.create(this, R.raw.thetuneofazurelight)
                    } else if (pos == 70) {
                        mPlayer = MediaPlayer.create(this, R.raw.shadowofincongruity)
                    } else if (pos == 71) {
                        mPlayer = MediaPlayer.create(this, R.raw.memoryofkritias)
                    } else if (pos == 72) {
                        mPlayer = MediaPlayer.create(this, R.raw.blackdungeon)
                    } else if (pos == 73) {
                        mPlayer = MediaPlayer.create(this, R.raw.aplacewherelifebegins)
                    } else if (pos == 74) {
                        mPlayer = MediaPlayer.create(this, R.raw.contaminatedsea)
                    } else if (pos == 75) {
                        mPlayer = MediaPlayer.create(this, R.raw.letempledemiroir)
                    } else if (pos == 76) {
                        mPlayer = MediaPlayer.create(this, R.raw.diffraction)
                    } else if (pos == 77) {
                        mPlayer = MediaPlayer.create(this, R.raw.mirroredcage)
                    } else if (pos == 78) {
                        mPlayer = MediaPlayer.create(this, R.raw.bloodycage)
                    } else if (pos == 79) {
                        mPlayer = MediaPlayer.create(this, R.raw.outpost)
                    } else if (pos == 80) {
                        mPlayer = MediaPlayer.create(this, R.raw.warcloud)
                    } else if (pos == 81) {
                        mPlayer = MediaPlayer.create(this, R.raw.strangefog)
                    } else if (pos == 82) {
                        mPlayer = MediaPlayer.create(this, R.raw.waveofemptiness)
                    } else if (pos == 83) {
                        mPlayer = MediaPlayer.create(this, R.raw.ferociousbattlefield)
                    } else if (pos == 84) {
                        mPlayer = MediaPlayer.create(this, R.raw.secretlabyrinth)
                    } else if (pos == 85) {
                        mPlayer = MediaPlayer.create(this, R.raw.eternalswamp)
                    } else if (pos == 86) {
                        mPlayer = MediaPlayer.create(this, R.raw.heartofsuffering)
                    } else if (pos == 87) {
                        mPlayer = MediaPlayer.create(this, R.raw.depthofpain)
                    } else if (pos == 88) {
                        mPlayer = MediaPlayer.create(this, R.raw.tearsoftheworld)
                    } else if (pos == 89) {
                        mPlayer = MediaPlayer.create(this, R.raw.theworldsend)
                    } else if (pos == 90) {
                        mPlayer = MediaPlayer.create(this, R.raw.subterminalpoint)
                    } else if (pos == 91) {
                        mPlayer = MediaPlayer.create(this, R.raw.templeofdarkness)
                    } else if (pos == 92) {
                        mPlayer = MediaPlayer.create(this, R.raw.throneofdarkness)
                    } else if (pos == 93) {
                        mPlayer = MediaPlayer.create(this, R.raw.worldhorizon)
                    } else if (pos == 94) {
                        mPlayer = MediaPlayer.create(this, R.raw.lostspace)
                    } else if (pos == 95) {
                        mPlayer = MediaPlayer.create(this, R.raw.awakenofoldgod)
                    } else if (pos == 96) {
                        mPlayer = MediaPlayer.create(this, R.raw.noonofjustice)
                    } else if (pos == 97) {
                        mPlayer = MediaPlayer.create(this, R.raw.twilightofflame)
                    } else if (pos == 98) {
                        mPlayer = MediaPlayer.create(this, R.raw.midnightofsilence)
                    } else if (pos == 99) {
                        mPlayer = MediaPlayer.create(this, R.raw.dawnofhope)
                    }
                    countArray[pos] = countArray[pos] + 1
                    mPlayer.start()
                    on = 1
                } else if (on == 1) {
                    Toast.makeText(applicationContext, "음악이 이미 실행 중입니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.answerButton.setOnClickListener {
            if (on == 0) {
                Toast.makeText(applicationContext, "음악이 실행 중이 아닙니다.", Toast.LENGTH_SHORT).show()
            }
            else if (on == 1) {
                var answerText = binding.answerText.text.toString()
                if (answerText != " ") {
                    if ((answerText == nameArray[pos]) || (answerText == nameArraySecond[pos]) || (answerText == nameArrayThird[pos]) ||
                        (answerText == nameArrayFourth[pos]) || (answerText == nameEngArray[pos])
                    ) {
                        score = score + 1
                        message += "정답입니다! "
                    }
                }
                binding.answerText.setText(null)
                mPlayer.stop()
                count = count + 1
                if (count == 30) {
                    val intent = Intent(this@PlayActivity, FinishActivity::class.java)
                    intent.putExtra("score", score)
                    startActivity(intent) // intent를 사용하여 FinishActivity 시작
                }
                else {
                    Toast.makeText(applicationContext, message + "현재 점수는 " + score + "점입니다.(" + count + "/30)", Toast.LENGTH_SHORT).show()
                    on = 0
                    message = ""
                }
            }
        }
    }

    override fun onBackPressed() {
        // super.onBackPressed()
    }
}