package com.example.instatram

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.EditText
import android.widget.ImageView

const val EXTRA_MESSAGE = "com.example.instatram.MESSAGE"
class PhotoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
        var picture = findViewById<ImageView>(R.id.imageView2)
    picture.setImageURI(Uri.parse(currentPhotoPath))

            images.add(currentPhotoPath)}
    fun goback(view : View){
        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        val intent = Intent(this,Camera::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)}
        val messagee = intent.getStringExtra(EXTRA_MESSAGE)
        if (messagee != null) {
            titles.add(messagee)}
        startActivity(intent)
    }}