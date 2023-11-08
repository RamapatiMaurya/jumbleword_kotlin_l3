package com.rama.jumbleword_kotlin_l3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var et: EditText? = null
    var string: String? = null
    var levelIntent: Intent? = null
    var musicIntent: Intent? = null
    var quit: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        quit = findViewById<View>(R.id.quit) as Button
        et = findViewById<View>(R.id.editText1) as EditText
        musicIntent = Intent(this, MusicService::class.java)
        startService(musicIntent)
        val window = this.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = this.resources.getColor(R.color.my_status_bar_yellow)
    }

    fun moveToNextActivity(v: View?) {
        levelIntent = Intent(this@MainActivity, LevelSelectActivity::class.java)
        string = et!!.text.toString().trim { it <= ' ' }
        if (string == "") {
            Toast.makeText(this@MainActivity, "Please enter your Name", Toast.LENGTH_LONG).show()
            et!!.setText("")
        } else {
            levelIntent!!.putExtra("name", et!!.text.toString())
            startActivity(levelIntent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        stopService(musicIntent)
        finish()
    }

    override fun onDestroy() {
        stopService(musicIntent)
        super.onDestroy()
    }

    fun quit(view: View?) {
       onBackPressed()
    }
}