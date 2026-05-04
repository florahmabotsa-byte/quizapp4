package com.example.quizapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("score", 0)

        val txtScore = findViewById<TextView>(R.id.txtScore)

        txtScore.text = "Your Score: $score"
    }
}
