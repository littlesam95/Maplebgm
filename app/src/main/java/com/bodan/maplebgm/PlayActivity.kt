package com.bodan.maplebgm

import android.content.Context
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.*
import com.bodan.maplebgm.databinding.ActivityPlayBinding
import kotlinx.coroutines.internal.SynchronizedObject

@Entity(tableName = "tb_bgmanswer")
data class BgmAnswer(
    @PrimaryKey(autoGenerate = true) val id : Int,
    var answer1 : String,
    var answer2 : String,
    var answer3 : String,
    var answer4 : String,
    var answer5 : String,
    var answer6 : String
)

@Dao
interface BgmAnswerDao {
    @Query("SELECT * FROM tb_bgmanswer")
    fun getAll(): List<BgmAnswer>

    @Insert
    fun insertAll(vararg bgmanswer : BgmAnswer)

    @Delete
    fun delete(bgmanswer : BgmAnswer)
}

@Database(entities = [BgmAnswer::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bgmanswerDao() : BgmAnswerDao

    companion object {
        private var instance : AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "database-contacts"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}

class PlayActivity : AppCompatActivity() {
    private var toast : Toast? = null
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
            toast?.cancel()
            toast = Toast.makeText(applicationContext, id + "님 환영합니다!", Toast.LENGTH_SHORT)
            toast?.show()
        }

        mPlayer = MediaPlayer.create(this, R.raw.abovethetreetops)
        binding.bgmplayButton.setOnClickListener {
            mPlayer.start()
        }
        binding.answerButton.setOnClickListener {
            var answerText = binding.answerText.text.toString()
            score = score + 1
            toast?.cancel()
            toast = Toast.makeText(applicationContext, "정답입니다! 현재 점수는 " + score + "점입니다.", Toast.LENGTH_SHORT)
            toast?.show()
            mPlayer.stop()
            mPlayer = MediaPlayer.create(this, R.raw.restnpeace)
        }
    }
}