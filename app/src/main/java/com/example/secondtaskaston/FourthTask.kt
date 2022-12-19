package com.example.secondtaskaston

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secondtaskaston.databinding.ActivityFourthTaskBinding

class FourthTask : AppCompatActivity() {
    lateinit var binding: ActivityFourthTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthTaskBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.apply {
            finishActButton.setOnClickListener {
                finish()
            }


        }
    }
}