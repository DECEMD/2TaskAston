package com.example.secondtaskaston

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.secondtaskaston.databinding.ActivityMainBinding
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.apply {
            button1.setOnClickListener {
                startAct(FirstTask::class.java)
            }

            button2.setOnClickListener {
                startAct(SecondTask::class.java)
            }

            button3.setOnClickListener {
                startAct(ThirdTask::class.java)
            }

            button4.setOnClickListener {
                startAct(FourthTask::class.java)
            }

            button5.setOnClickListener {
                startAct(FifthTask::class.java)
            }

            button6.setOnClickListener {
                startAct(SixthTaskFirstAct::class.java)
            }

            button7.setOnClickListener {
                startAct(SeventhTask::class.java)
            }

            button8.setOnClickListener {
                startAct(EightTask::class.java)
            }
        }
    }

    private fun startAct(cls: Class<*>){
        startActivity(Intent(this, cls))
    }
}