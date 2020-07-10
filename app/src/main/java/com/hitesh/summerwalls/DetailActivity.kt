package com.hitesh.summerwalls

import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import com.squareup.picasso.Picasso.LoadedFrom
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DetailActivity : AppCompatActivity() {

    var imageText: String? = null
    var imageUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var intent = intent
        var imageText = intent.getStringExtra("imageText")
        var imageUrl = intent.getStringExtra("imageUrl")



        CoroutineScope(IO).launch {
            val loadImage = async {
                var result = Glide.with(applicationContext).asBitmap().load(imageUrl).submit().get()
                result
            }

            var result: Bitmap = loadImage.await()

            loadImage.join()
            withContext(Main){
                wallpaperView.setImageBitmap(result)
            }

            withContext(Main){
                setWallpaper.isEnabled = loadImage.isCompleted
            }

            setWallpaper.setOnClickListener {
                if (result != null) {
                    setWall(result)
                }
            }
        }
    }

    fun setWall(bitmap: Bitmap){
        val wallpaperManager = WallpaperManager.getInstance(applicationContext)
        wallpaperManager.setBitmap(bitmap)
    }
}