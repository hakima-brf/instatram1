package com.example.instatram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun startapp(view: View) {
        // Do something in response to button
        val intent = Intent(this, MainActivity2::class.java).apply{}

        startActivity(intent)
    }


}