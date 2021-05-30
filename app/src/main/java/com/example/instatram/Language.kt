package com.example.instatram

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import java.util.*

@Suppress("DEPRECATION")
class Language : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    fun setAppLocale(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = context.resources.configuration
        config.setLocale(locale)
        context.createConfigurationContext(config)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }
   @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    fun english(view: View) {
        setAppLocale(this, "en")
        val intent = Intent(this, Language::class.java)
        startActivity(intent)
    }


    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
     fun spanish(view: View) {
        setAppLocale(this, "es")
        val intent = Intent(this, Language::class.java)
        startActivity(intent)
    }


}