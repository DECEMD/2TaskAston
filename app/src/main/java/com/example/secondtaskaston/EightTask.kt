package com.example.secondtaskaston

import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.secondtaskaston.databinding.ActivityEightTaskBinding


class EightTask : AppCompatActivity() {
    lateinit var binding: ActivityEightTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEightTaskBinding.inflate(layoutInflater).also { setContentView(it.root) }

        binding.apply {

            websiteButton.setOnClickListener {
                val url = edWebsite.text.toString()
                val webpage: Uri = Uri.parse(url)
                val intent = Intent(Intent.ACTION_VIEW, webpage)
                if (isIntentAvailable(intent)) {
                    startActivity(intent)
                } else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }

            locationButton.setOnClickListener {
                val loc = edLocation.text.toString()
                val addressUri = Uri.parse("geo:0,0?q= $loc")
                val intent = Intent(Intent.ACTION_VIEW, addressUri)
                if (isIntentAvailable(intent)) {
                    startActivity(intent)
                } else {
                    Log.d("ImplicitIntents", "Can't handle this intent!")
                }
            }

            edShareButton.setOnClickListener {
                Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, edShareText.text)
                    putExtra(
                        Intent.EXTRA_SUBJECT,
                        "Отправка сообщения")
                }.also {
                    val chooserIntent =
                        Intent.createChooser(it, "Отправить сюда")
                    startActivity(chooserIntent)
                }
            }

            takePictureButton.apply {
                val captureImage = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
                    flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                }
                if (isIntentAvailable(captureImage)) {
                    setOnClickListener {
                        startActivity(captureImage)
                    }
                } else {
                    Toast.makeText(this@EightTask, "There is no apps that can handle this intent", Toast.LENGTH_SHORT).show()
                }
            }
            finishActButton.setOnClickListener {
                finish()
            }
        }
    }

    private fun isIntentAvailable(intent: Intent): Boolean {
        val intentInfo = intent.resolveActivity(packageManager)
        return intentInfo != null
    }
}