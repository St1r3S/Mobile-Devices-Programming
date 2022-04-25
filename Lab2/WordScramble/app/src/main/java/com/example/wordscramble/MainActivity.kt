package com.example.wordscramble

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wordscramble.databinding.ActivityMainBinding
import kotlin.random.Random

const val INITIAL_SCORE_VALUE: Int = 0
const val SCORE_CHARGES: Int = 321

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.scoreValue.text = INITIAL_SCORE_VALUE.toString()

        startGame()
    }

    private fun startGame() {

        val word = getRandomWord()
        val scrambledWord = word.toCharArray().let {
            it.shuffle()
            it.concatToString()
        }

        binding.scrambledWord.text = scrambledWord
        binding.answerCheckButton.setOnClickListener {

            val userWord = binding.usersAnswer.text.toString() ?: ""

            if (userWord == word) {
                Toast.makeText(this, "Yep)!", Toast.LENGTH_SHORT).show()

                var scoreValue: Int = binding.scoreValue.text.toString().toInt()
                scoreValue += SCORE_CHARGES
                binding.scoreValue.text = scoreValue.toString()

                startGame()
            } else {
                Toast.makeText(this, "Dumb!", Toast.LENGTH_SHORT).show()
                binding.scoreValue.text = INITIAL_SCORE_VALUE.toString()
            }
        }

    }

    private fun getRandomWord(): String {
        val words = resources.getStringArray(R.array.words)
        return words[Random.nextInt(words.size)]
    }
}

