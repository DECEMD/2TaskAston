package com.example.secondtaskaston

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.secondtaskaston.databinding.ActivitySixthTaskFirstBinding

class SixthTaskFirstAct : AppCompatActivity() {
    lateinit var binding: ActivitySixthTaskFirstBinding
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivitySixthTaskFirstBinding.inflate(layoutInflater).also { setContentView(it.root) }

        if (savedInstanceState != null) {
            updateUi(counter)
        } else {
            binding.showCurrentCounter.text = "0"
        }

        binding.apply {
            countButton.setOnClickListener {
                counter++
                updateUi(counter)
            }

            sayHelloButton.setOnClickListener {
                startActivity(Intent(this@SixthTaskFirstAct, SixthTaskSecondAct::class.java).apply {
                    putExtra("counter", counter)
                })
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

    private fun updateUi(counter: Int) {
        binding.showCurrentCounter.text = counter.toString()
    }
}
