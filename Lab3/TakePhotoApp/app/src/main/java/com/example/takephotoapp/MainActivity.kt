package com.example.takephotoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.lifecycle.lifecycleScope
import com.example.takephotoapp.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClickListeners()
    }

    private val takeAPhotoLauncher =
        registerForActivityResult(ActivityResultContracts.TakePicture()) { isSuccess ->
            if (isSuccess) {
                latestTemporaryURI?.let { uri ->
                    binding.photoPreview.setImageURI(uri)
                }
            }
        }

    private val selectPhotoFromGalleryLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            latestTemporaryURI = uri
            uri?.let { binding.photoPreview.setImageURI(uri) }
        }

    private var latestTemporaryURI: Uri? = null

    private fun setOnClickListeners() {
        binding.takeAPhotoButton.setOnClickListener { takeAPhoto() }
        binding.selectPhotoButton.setOnClickListener { selectPhotoFromGallery() }
        binding.sendPhotoButton.setOnClickListener {
            val i = Intent(Intent.ACTION_SEND)
            i.type = "text/plain"
            i.putExtra(Intent.EXTRA_SUBJECT, "КПП НАИ-196 Зубанич")
            i.putExtra(Intent.EXTRA_STREAM, latestTemporaryURI)
            startActivity(i)
        }
    }

    private fun takeAPhoto() {
        lifecycleScope.launchWhenStarted {
            getTemporaryFileURI().let { uri ->
                latestTemporaryURI = uri
                takeAPhotoLauncher.launch(uri)
            }
        }
    }

    private fun selectPhotoFromGallery() = selectPhotoFromGalleryLauncher.launch("image/*")

    private fun getTemporaryFileURI(): Uri {
        val tempFile = File.createTempFile("temp_photo_file", ".png", cacheDir).apply {
            createNewFile()
            deleteOnExit()
        }

        return FileProvider.getUriForFile(applicationContext,
            "${BuildConfig.APPLICATION_ID}.provider",
            tempFile)
    }
}