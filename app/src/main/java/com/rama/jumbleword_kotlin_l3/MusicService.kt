package com.rama.jumbleword_kotlin_l3

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder


class MusicService : Service() {
    var mp: MediaPlayer? = null
    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        mp = MediaPlayer.create(this, R.raw.faded)
        mp!!.isLooping = true
        mp!!.setVolume(100f, 100f)
        mp!!.start()
        return START_STICKY
    }

    override fun onDestroy() {
        mp!!.stop()
        mp!!.release()
        super.onDestroy()
    }
}