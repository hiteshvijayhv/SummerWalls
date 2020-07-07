package com.hitesh.summerwalls

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hitesh.summerwalls.adapter.WallAdapter
import com.hitesh.summerwalls.repository.WallsData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var wallsData: WallsData? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wallsData = WallsData()


        val wallItemsList = wallsData?.inputWallUrls(wallsData!!.wallArrayLenght)
        walls_adapter.adapter = WallAdapter(wallItemsList!!)
        walls_adapter.layoutManager = GridLayoutManager(applicationContext, 2)
        walls_adapter.setHasFixedSize(true)

    }

}
