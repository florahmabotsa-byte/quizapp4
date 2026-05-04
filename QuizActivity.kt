package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private var score = 0
    private var index = 0

    private val questions = arrayOf(
        "Using public WiFi is always safe",
        "Strong passwords improve security",
        "Hackers only target rich people"
    )

    private val answers = arrayOf(false, true, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val txtQuestion = findViewById<TextView>(R.id.txtQuestion)
        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val txtFeedback = findViewById<TextView>(R.id.txtFeedback)

        txtQuestion.text = questions[index]

        btnTrue.setOnClickListener {
            checkAnswer(true, txtFeedback)
        }

        btnFalse.setOnClickListener {
            checkAnswer(false, txtFeedback)
        }

        btnNext.setOnClickListener {
            index++
            if (index < questions.size) {
                txtQuestion.text = questions[index]
                txtFeedback.text = ""
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
            }
        }
    }

    private fun checkAnswer(userAnswer: Boolean, feedback: TextView) {
        if (userAnswer == answers[index]) {
            feedback.text = "Correct!"
            score++
        } else {
            feedback.text = "Wrong!"
        }
    }
}
