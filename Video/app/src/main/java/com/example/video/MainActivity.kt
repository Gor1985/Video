package com.example.video

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.MediaController
import android.widget.VideoView
import com.example.video.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val MediaController=MediaController(this)
        val videoView = binding.videoView//связываем переменную с разметкой
        val path = "android.resource://" + packageName + "/" + R.raw.video
        videoView?.setVideoURI(Uri.parse(path))// прописываем и загружаем в нашу переменную путь к видео и область памяти с видео
        MediaController.setAnchorView(videoView)//устанавливаем режим привязки к медиаконтролеру
       videoView.setMediaController(MediaController)//записываем в переменную с видео медиаконтролер и получаем регулировку видео
        videoView.start()// включаем видео
    }
}