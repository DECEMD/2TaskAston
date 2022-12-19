package com.example.secondtaskaston

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secondtaskaston.databinding.ActivitySixthTaskFirstBinding
import com.example.secondtaskaston.databinding.ActivitySixthTaskSecondBinding

class SixthTaskSecondAct : AppCompatActivity() {
    lateinit var binding: ActivitySixthTaskSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySixthTaskSecondBinding.inflate(layoutInflater).also { setContentView(it.root) }
        getStringAndPlaceTv()

        binding.finishActButton2.setOnClickListener {
            finish()
        }
    }

    private fun getStringAndPlaceTv(){
        binding.tvCounterResult.text = intent.extras?.getInt("counter").toString()
    }
}