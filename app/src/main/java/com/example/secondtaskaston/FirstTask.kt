package com.example.secondtaskaston

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.secondtaskaston.databinding.ActivityFirstTaskBinding
import java.lang.RuntimeException

class FirstTask : AppCompatActivity() {
    lateinit var binding: ActivityFirstTaskBinding
    var birthdayString = "Pavel"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstTaskBinding.inflate(layoutInflater).also { setContentView(it.root) }

        Log.d("MainActivity", "Hello World")
        binding.textView.text = getString(R.string.mainStr, birthdayString)
    }

    override fun onResume() {
        super.onResume()
        binding.finishActButton.setOnClickListener { finish() }
    }
}