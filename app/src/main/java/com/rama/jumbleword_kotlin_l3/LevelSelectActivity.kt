package com.rama.jumbleword_kotlin_l3

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rama.jumbleword_kotlin_l3.databinding.ActivityGameBinding
import com.rama.jumbleword_kotlin_l3.databinding.ActivityLevelBinding


class LevelSelectActivity : AppCompatActivity() {
    var adb: AlertDialog.Builder? = null
    var name: String? = null

    lateinit var levelBinding: ActivityLevelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        levelBinding = ActivityLevelBinding.inflate(layoutInflater)
        setContentView(levelBinding.root)
        adb = AlertDialog.Builder(this)
        name = intent?.getStringExtra("name")
        levelBinding.greetings.text = "Welcome $name"
        val window = this.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = this.resources.getColor(R.color.my_status_bar_red)
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish()
        }
    }

    fun beginner(v: View?) {
        Toast.makeText(this@LevelSelectActivity, levelBinding.radio0.text.toString() + " level", Toast.LENGTH_SHORT)
            .show()
        val beginer = Intent(this@LevelSelectActivity, GamePlayActivity::class.java)
        beginer.putExtra("name", name)
        beginer.putExtra("level", "Beginner")
        startActivity(beginer)
    }

    fun intermediate(v: View?) {
        Toast.makeText(this@LevelSelectActivity, levelBinding.radio1.text.toString() + " level", Toast.LENGTH_SHORT)
            .show()
        val intermediate = Intent(this@LevelSelectActivity, GamePlayActivity::class.java)
        intermediate.putExtra("name", name)
        intermediate.putExtra("level", "Intermediate")
        startActivity(intermediate)
    }

    fun expert(v: View?) {
        Toast.makeText(this@LevelSelectActivity, levelBinding.radio2.text.toString() + " level", Toast.LENGTH_SHORT)
            .show()
        val expert = Intent(this@LevelSelectActivity, GamePlayActivity::class.java)
        expert.putExtra("name", name)
        expert.putExtra("level", "Expert")
        startActivity(expert)
    } /*
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
    */
    /*
    public void exit(View v)
    {
        adb.setTitle("Quit?");
        adb.setMessage("Do you really want to quit?");
        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                //finish();
                LevelSelect.this.onBackPressed();
            }
        });
        adb.setNegativeButton("No", null);
        adb.show();

    }
*/
}