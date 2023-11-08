package com.rama.jumbleword_kotlin_l3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rama.jumbleword_kotlin_l3.databinding.ActivityLevelBinding
import com.rama.jumbleword_kotlin_l3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var string: String? = null
    var musicIntent: Intent? = null

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        musicIntent = Intent(this, MusicService::class.java)
        startService(musicIntent)
        val window = this.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = this.resources.getColor(R.color.my_status_bar_yellow)
    }

    fun moveToNextActivity(v: View?) {
        val levelIntent = Intent(this@MainActivity, LevelSelectActivity::class.java)
        string = binding.editText1.text.toString().trim { it <= ' ' }
        if (string == "") {
            Toast.makeText(this@MainActivity, "Please enter your Name", Toast.LENGTH_LONG).show()
            binding.editText1.setText("")
        } else {
            levelIntent.putExtra("name", binding.editText1.text.toString())
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