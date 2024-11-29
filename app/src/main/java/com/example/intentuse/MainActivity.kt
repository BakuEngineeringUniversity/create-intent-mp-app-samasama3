package com.example.intentuse

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("message", "Hello from MainActivity")
            startActivity(intent)
        }

        val playButton: Button = findViewById(R.id.play_button)

        mediaPlayer = MediaPlayer.create(this, R.raw.star)

        playButton.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
                playButton.text = "Pause Song"
            } else {
                mediaPlayer.pause()
                playButton.text = "Play Song"
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
