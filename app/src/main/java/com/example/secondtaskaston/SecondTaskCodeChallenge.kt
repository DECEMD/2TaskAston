package com.example.secondtaskaston

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.secondtaskaston.databinding.ActivitySecondTaskBinding
import com.example.secondtaskaston.databinding.ActivitySecondTaskCodeChallengeBinding

class SecondTaskCodeChallenge : AppCompatActivity() {
    lateinit var binding: ActivitySecondTaskCodeChallengeBinding
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondTaskCodeChallengeBinding.inflate(layoutInflater).also { setContentView(it.root) }

        if (savedInstanceState != null){
            updateUi(counter)
        } else {
            binding.showCurrentCounter.text = "0"
        }

        binding.apply {
            countButton.setOnClickListener {
                counter++
                updateUi(counter)
            }

            toastButton.setOnClickListener {
                Toast.makeText(this@SecondTaskCodeChallenge, "Hello Toast!", Toast.LENGTH_SHORT).show()
            }

            finishActButton.setOnClickListener {
                finish()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
            val statedString = savedInstanceState.getInt("counter")
            counter = statedString
            updateUi(statedString)
    }

    private fun updateUi(counter: Int){
        binding.showCurrentCounter.text = counter.toString()
    }
}