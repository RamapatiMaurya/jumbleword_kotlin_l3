package com.rama.jumbleword_kotlin_l3

import android.app.AlertDialog
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rama.jumbleword_kotlin_l3.databinding.ActivityGameBinding
import java.util.Collections
import java.util.Random


class GamePlayActivity : AppCompatActivity() {
    var alertDialog: AlertDialog.Builder? = null
    var db: SQLiteDatabase? = null
    var n: String? = null
    var lv: String? = null
    var s = ""
    var quesWord = ArrayList<String?>()
    var score = 0
    var chances = 3
    var c: Cursor? = null
    lateinit var gameBinding: ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameBinding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(gameBinding.root)
        n = intent.getStringExtra("name")
        gameBinding.name.text = "Player: $n"
        lv = intent.getStringExtra("level")
        gameBinding.lvdisp.text = "Level: $lv"
        createTable()
        insertIntoBeginner()
        insertIntoIntermediate()
        insertIntoExpert()
        fetchWords()
        alertDialog = AlertDialog.Builder(this)
        val window = this.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = this.resources.getColor(R.color.my_status_bar_pink)
    }

    fun createTable() {
        db = openOrCreateDatabase("com.rama.jumbleword_kotlin_l3", MODE_PRIVATE, null)
        try {
            db!!.execSQL("create table if not exists jumbleword(word varchar(7) primary key not null,level varchar(15))")
        } catch (e: Exception) {
        }
    }

    fun insertIntoBeginner() {
        try {
            db!!.execSQL("insert into jumbleword values('above','Beginner')")
            db!!.execSQL("insert into jumbleword values('alert','Beginner')")
            db!!.execSQL("insert into jumbleword values('bench','Beginner')")
            db!!.execSQL("insert into jumbleword values('blood','Beginner')")
            db!!.execSQL("insert into jumbleword values('chart','Beginner')")
            db!!.execSQL("insert into jumbleword values('class','Beginner')")
            db!!.execSQL("insert into jumbleword values('daily','Beginner')")
            db!!.execSQL("insert into jumbleword values('death','Beginner')")
            db!!.execSQL("insert into jumbleword values('entry','Beginner')")
            db!!.execSQL("insert into jumbleword values('extra','Beginner')")
            db!!.execSQL("insert into jumbleword values('flood','Beginner')")
            db!!.execSQL("insert into jumbleword values('force','Beginner')")
            db!!.execSQL("insert into jumbleword values('globe','Beginner')")
            db!!.execSQL("insert into jumbleword values('guard','Beginner')")
            db!!.execSQL("insert into jumbleword values('house','Beginner')")
            db!!.execSQL("insert into jumbleword values('heavy','Beginner')")
            db!!.execSQL("insert into jumbleword values('index','Beginner')")
            db!!.execSQL("insert into jumbleword values('image','Beginner')")
            db!!.execSQL("insert into jumbleword values('joint','Beginner')")
            db!!.execSQL("insert into jumbleword values('laser','Beginner')")
            db!!.execSQL("insert into jumbleword values('learn','Beginner')")
            db!!.execSQL("insert into jumbleword values('local','Beginner')")
            db!!.execSQL("insert into jumbleword values('month','Beginner')")
            db!!.execSQL("insert into jumbleword values('minor','Beginner')")
            db!!.execSQL("insert into jumbleword values('mouse','Beginner')")
            db!!.execSQL("insert into jumbleword values('never','Beginner')")
            db!!.execSQL("insert into jumbleword values('noise','Beginner')")
            db!!.execSQL("insert into jumbleword values('north','Beginner')")
            db!!.execSQL("insert into jumbleword values('offer','Beginner')")
            db!!.execSQL("insert into jumbleword values('order','Beginner')")
            db!!.execSQL("insert into jumbleword values('paint','Beginner')")
            db!!.execSQL("insert into jumbleword values('paper','Beginner')")
            db!!.execSQL("insert into jumbleword values('raise','Beginner')")
            db!!.execSQL("insert into jumbleword values('right','Beginner')")
            db!!.execSQL("insert into jumbleword values('sense','Beginner')")
            db!!.execSQL("insert into jumbleword values('sharp','Beginner')")
            db!!.execSQL("insert into jumbleword values('sleep','Beginner')")
            db!!.execSQL("insert into jumbleword values('solve','Beginner')")
            db!!.execSQL("insert into jumbleword values('table','Beginner')")
            db!!.execSQL("insert into jumbleword values('tight','Beginner')")
            db!!.execSQL("insert into jumbleword values('throw','Beginner')")
            db!!.execSQL("insert into jumbleword values('today','Beginner')")
            db!!.execSQL("insert into jumbleword values('upper','Beginner')")
            db!!.execSQL("insert into jumbleword values('upset','Beginner')")
            db!!.execSQL("insert into jumbleword values('value','Beginner')")
            db!!.execSQL("insert into jumbleword values('valid','Beginner')")
            db!!.execSQL("insert into jumbleword values('waste','Beginner')")
            db!!.execSQL("insert into jumbleword values('while','Beginner')")
            db!!.execSQL("insert into jumbleword values('youth','Beginner')")
            db!!.execSQL("insert into jumbleword values('young','Beginner')")
        } catch (e: Exception) {
        }
    }

    fun insertIntoIntermediate() {
        try {
            db!!.execSQL("insert into jumbleword values('abroad','Intermediate')")
            db!!.execSQL("insert into jumbleword values('across','Intermediate')")
            db!!.execSQL("insert into jumbleword values('belong','Intermediate')")
            db!!.execSQL("insert into jumbleword values('bright','Intermediate')")
            db!!.execSQL("insert into jumbleword values('carbon','Intermediate')")
            db!!.execSQL("insert into jumbleword values('career','Intermediate')")
            db!!.execSQL("insert into jumbleword values('degree','Intermediate')")
            db!!.execSQL("insert into jumbleword values('design','Intermediate')")
            db!!.execSQL("insert into jumbleword values('effort','Intermediate')")
            db!!.execSQL("insert into jumbleword values('engine','Intermediate')")
            db!!.execSQL("insert into jumbleword values('factor','Intermediate')")
            db!!.execSQL("insert into jumbleword values('famous','Intermediate')")
            db!!.execSQL("insert into jumbleword values('future','Intermediate')")
            db!!.execSQL("insert into jumbleword values('garden','Intermediate')")
            db!!.execSQL("insert into jumbleword values('gender','Intermediate')")
            db!!.execSQL("insert into jumbleword values('global','Intermediate')")
            db!!.execSQL("insert into jumbleword values('hardly','Intermediate')")
            db!!.execSQL("insert into jumbleword values('height','Intermediate')")
            db!!.execSQL("insert into jumbleword values('holder','Intermediate')")
            db!!.execSQL("insert into jumbleword values('hidden','Intermediate')")
            db!!.execSQL("insert into jumbleword values('hockey','Intermediate')")
            db!!.execSQL("insert into jumbleword values('injury','Intermediate')")
            db!!.execSQL("insert into jumbleword values('island','Intermediate')")
            db!!.execSQL("insert into jumbleword values('junior','Intermediate')")
            db!!.execSQL("insert into jumbleword values('jungle','Intermediate')")
            db!!.execSQL("insert into jumbleword values('killer','Intermediate')")
            db!!.execSQL("insert into jumbleword values('kidney','Intermediate')")
            db!!.execSQL("insert into jumbleword values('letter','Intermediate')")
            db!!.execSQL("insert into jumbleword values('launch','Intermediate')")
            db!!.execSQL("insert into jumbleword values('lesson','Intermediate')")
            db!!.execSQL("insert into jumbleword values('liquid','Intermediate')")
            db!!.execSQL("insert into jumbleword values('little','Intermediate')")
            db!!.execSQL("insert into jumbleword values('living','Intermediate')")
            db!!.execSQL("insert into jumbleword values('manage','Intermediate')")
            db!!.execSQL("insert into jumbleword values('manner','Intermediate')")
            db!!.execSQL("insert into jumbleword values('method','Intermediate')")
            db!!.execSQL("insert into jumbleword values('native','Intermediate')")
            db!!.execSQL("insert into jumbleword values('notice','Intermediate')")
            db!!.execSQL("insert into jumbleword values('office','Intermediate')")
            db!!.execSQL("insert into jumbleword values('patent','Intermediate')")
            db!!.execSQL("insert into jumbleword values('random','Intermediate')")
            db!!.execSQL("insert into jumbleword values('rating','Intermediate')")
            db!!.execSQL("insert into jumbleword values('remove','Intermediate')")
            db!!.execSQL("insert into jumbleword values('screen','Intermediate')")
            db!!.execSQL("insert into jumbleword values('secure','Intermediate')")
            db!!.execSQL("insert into jumbleword values('theory','Intermediate')")
            db!!.execSQL("insert into jumbleword values('unique','Intermediate')")
            db!!.execSQL("insert into jumbleword values('vision','Intermediate')")
            db!!.execSQL("insert into jumbleword values('winter','Intermediate')")
            db!!.execSQL("insert into jumbleword values('yellow','Intermediate')")
        } catch (e: Exception) {
        }
    }

    fun insertIntoExpert() {
        try {
            db!!.execSQL("insert into jumbleword values('account','Expert')")
            db!!.execSQL("insert into jumbleword values('acquire','Expert')")
            db!!.execSQL("insert into jumbleword values('bedroom','Expert')")
            db!!.execSQL("insert into jumbleword values('benefit','Expert')")
            db!!.execSQL("insert into jumbleword values('century','Expert')")
            db!!.execSQL("insert into jumbleword values('captain','Expert')")
            db!!.execSQL("insert into jumbleword values('decline','Expert')")
            db!!.execSQL("insert into jumbleword values('develop','Expert')")
            db!!.execSQL("insert into jumbleword values('economy','Expert')")
            db!!.execSQL("insert into jumbleword values('example','Expert')")
            db!!.execSQL("insert into jumbleword values('faculty','Expert')")
            db!!.execSQL("insert into jumbleword values('fiction','Expert')")
            db!!.execSQL("insert into jumbleword values('gallery','Expert')")
            db!!.execSQL("insert into jumbleword values('genuine','Expert')")
            db!!.execSQL("insert into jumbleword values('healthy','Expert')")
            db!!.execSQL("insert into jumbleword values('hundred','Expert')")
            db!!.execSQL("insert into jumbleword values('imagine','Expert')")
            db!!.execSQL("insert into jumbleword values('improve','Expert')")
            db!!.execSQL("insert into jumbleword values('journal','Expert')")
            db!!.execSQL("insert into jumbleword values('justice','Expert')")
            db!!.execSQL("insert into jumbleword values('kitchen','Expert')")
            db!!.execSQL("insert into jumbleword values('kingdom','Expert')")
            db!!.execSQL("insert into jumbleword values('leisure','Expert')")
            db!!.execSQL("insert into jumbleword values('logical','Expert')")
            db!!.execSQL("insert into jumbleword values('machine','Expert')")
            db!!.execSQL("insert into jumbleword values('mineral','Expert')")
            db!!.execSQL("insert into jumbleword values('nuclear','Expert')")
            db!!.execSQL("insert into jumbleword values('nervous','Expert')")
            db!!.execSQL("insert into jumbleword values('officer','Expert')")
            db!!.execSQL("insert into jumbleword values('outside','Expert')")
            db!!.execSQL("insert into jumbleword values('partial','Expert')")
            db!!.execSQL("insert into jumbleword values('passive','Expert')")
            db!!.execSQL("insert into jumbleword values('quality','Expert')")
            db!!.execSQL("insert into jumbleword values('quarter','Expert')")
            db!!.execSQL("insert into jumbleword values('receive','Expert')")
            db!!.execSQL("insert into jumbleword values('replace','Expert')")
            db!!.execSQL("insert into jumbleword values('science','Expert')")
            db!!.execSQL("insert into jumbleword values('session','Expert')")
            db!!.execSQL("insert into jumbleword values('teacher','Expert')")
            db!!.execSQL("insert into jumbleword values('trouble','Expert')")
            db!!.execSQL("insert into jumbleword values('upgrade','Expert')")
            db!!.execSQL("insert into jumbleword values('utility','Expert')")
            db!!.execSQL("insert into jumbleword values('vehicle','Expert')")
            db!!.execSQL("insert into jumbleword values('veteran','Expert')")
            db!!.execSQL("insert into jumbleword values('welcome','Expert')")
            db!!.execSQL("insert into jumbleword values('western','Expert')")
            db!!.execSQL("insert into jumbleword values('undress','Expert')")
            db!!.execSQL("insert into jumbleword values('venture','Expert')")
            db!!.execSQL("insert into jumbleword values('visible','Expert')")
            db!!.execSQL("insert into jumbleword values('yoghurt','Expert')")
        } catch (e: Exception) {
        }
    }

    fun fetchWords() {
        try {
            c = db!!.rawQuery("select * from jumbleword where level='$lv'", null)
            while (c!!.moveToNext()) {
                s = c!!.getString(0)
                quesWord.add(s)
            }
            Collections.shuffle(quesWord)
        } catch (e: Exception) {
        }
    }

    override fun onResume() {
        super.onResume()
        val str = quesWord.toTypedArray()
        gameBinding.attemp.text = "Attempts left: $chances"
        gameBinding.score.text = "Score: $score"
        gameBinding.jumbled.text = wordJumble(str[0])
        gameBinding.match.setOnClickListener(object : View.OnClickListener {
            var j = 0
            var len = str.size
            override fun onClick(v: View) {
                try {
                    if (gameBinding.ans.text.toString().trim { it <= ' ' }
                            .equals(str[j], ignoreCase = true)) {
                        score++
                        if (score == len) {
                            alertDialog!!.setTitle("You Won!")
                            alertDialog!!.setMessage("Score: $score")
                            alertDialog!!.setPositiveButton(
                                "Okay"
                            ) { dialog, which -> finish() }
                            alertDialog!!.show()
                        }
                        j++
                        gameBinding.score.text = "Score: $score"
                        gameBinding.jumbled.text = wordJumble(str[j])
                        gameBinding.ans.setText("")
                    } else {
                        chances--
                        Toast.makeText(applicationContext, "Wrong Answer", Toast.LENGTH_SHORT)
                            .show()
                        if (chances == 0) {
                            alertDialog!!.setTitle("You Lose!")
                            alertDialog!!.setMessage("Score: $score")
                            alertDialog!!.setPositiveButton(
                                "Okay"
                            ) { dialog, which -> finish() }
                            alertDialog!!.show()
                        }
                        gameBinding.attemp.text = "Attempts left: $chances"
                        gameBinding.ans.setText("")
                    }
                } catch (e: Exception) {
                }
            }
        })
    }

    fun back(v: View?) {
        alertDialog!!.setTitle("Go Back?")
        alertDialog!!.setMessage("Are you sure you want to go back?")
        alertDialog!!.setNegativeButton(
            "Yes"
        ) { dialog, which -> finish() }
        alertDialog!!.setPositiveButton("No", null)
        alertDialog!!.show()
    }

    companion object {
        fun wordJumble(word: String?): String {
            val random = Random()
            val wordArray = word!!.toCharArray()
            for (i in 0 until wordArray.size - 1) {
                val j = random.nextInt(wordArray.size - 1)
                val temp = wordArray[i]
                wordArray[i] = wordArray[j]
                wordArray[j] = temp
            }
            if (wordArray.toString() == word) {
                wordJumble(word)
            }
            return String(wordArray)
        }
    }
}