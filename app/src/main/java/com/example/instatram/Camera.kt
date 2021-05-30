package com.example.instatram

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView import android.widget.TextView
import androidx.core.content.FileProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.io.IOException import java.net.URI
import java.text.SimpleDateFormat
import java.util.*

lateinit var currentPhotoPath: String
val REQUEST_IMAGE_CAPTURE = 1
class Camera : AppCompatActivity() {
    private var layoutManager : RecyclerView.LayoutManager? = null
    private var adapter : RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
    layoutManager = LinearLayoutManager(this)
        var recycle = findViewById<RecyclerView>(R.id.recycleview)
        recycle.layoutManager= layoutManager
        adapter = MainRecyclerAdapter()
        recycle.adapter= adapter }
    lateinit var hh: String
    @Throws(IOException::class)
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile( "JPEG_${timeStamp}_", /* prefix */ ".jpg", /* suffix */ storageDir /* directory */ ).apply { // Save a file: path for use with ACTION_VIEW intents
             currentPhotoPath = absolutePath } }
    public fun takepicture (view: View) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if(intent.resolveActivity(packageManager) != null) {
            var photoFile: File? = null
            try{
                photoFile = createImageFile() }
            catch (e: IOException){}
            if(photoFile != null){
                val photoUri = FileProvider.getUriForFile( this, BuildConfig.APPLICATION_ID + ".fileprovider", photoFile )
                intent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri)
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE) } } }
    @SuppressLint("MissingSuperCall")
    override public fun onActivityResult (requestCode: Int, resultCode: Int, data: Intent?) {


    if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
        val intentt = Intent(this, PhotoActivity::class.java)
        startActivity(intentt) } } }