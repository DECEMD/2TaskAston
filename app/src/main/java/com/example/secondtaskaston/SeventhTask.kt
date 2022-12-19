package com.example.secondtaskaston

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.secondtaskaston.databinding.ActivitySeventhTaskBinding

class SeventhTask : AppCompatActivity() {
    lateinit var binding: ActivitySeventhTaskBinding
    var counter = 0
    var statedText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeventhTaskBinding.inflate(layoutInflater).also { setContentView(it.root) }

        if (savedInstanceState != null){
            updateUi(statedText, true)
        } else {
            binding.tvCounter.text = "0"
            binding.edToRotate.setText("")
        }

        binding.apply {

            countButton.setOnClickListener {
                counter++
                updateUi(statedText, false)
            }

            finishActButton.setOnClickListener {
                finish()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("edText", binding.edToRotate.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        statedText = savedInstanceState.getString("edText").toString()
        updateUi(statedText, true)
    }

    private fun updateUi(statedText: String, shouldRestoreEdText: Boolean){
        if (shouldRestoreEdText){
            binding.edToRotate.setText(statedText)
            binding.tvCounter.text = counter.toString()
        } else {
            binding.tvCounter.text = counter.toString()
        }

    }
}