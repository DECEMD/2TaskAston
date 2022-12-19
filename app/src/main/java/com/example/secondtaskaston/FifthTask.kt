package com.example.secondtaskaston

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secondtaskaston.databinding.ActivityFifthTaskBinding
import com.example.secondtaskaston.databinding.ActivityFirstTaskBinding

class FifthTask : AppCompatActivity() {
    lateinit var binding: ActivityFifthTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthTaskBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.finishActButton.setOnClickListener {
            finish()
        }
    }
}