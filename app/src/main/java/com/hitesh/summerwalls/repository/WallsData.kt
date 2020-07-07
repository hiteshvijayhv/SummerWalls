package com.hitesh.summerwalls.repository

import androidx.lifecycle.ViewModel
import com.hitesh.summerwalls.WallViewItems

class WallsData{

    var wallURL = arrayOf(
        "https://user-images.githubusercontent.com/46933160/85002367-6e1cf100-b172-11ea-9cd6-e5ff1a5fcce5.jpg",
        "https://user-images.githubusercontent.com/46933160/85002383-72490e80-b172-11ea-9346-af8ca6d605b7.jpg",
        "https://user-images.githubusercontent.com/46933160/85002400-783eef80-b172-11ea-9efc-036c3bfeee49.jpg",
        "https://user-images.githubusercontent.com/46933160/85002422-7e34d080-b172-11ea-9317-9b0bc045fcf2.jpg",
        "https://user-images.githubusercontent.com/46933160/85002437-82f98480-b172-11ea-993a-2947d715c6e8.png")

    var wallArrayLenght = wallURL.size

    fun inputWallUrls(size: Int): List<WallViewItems> {
        val list = ArrayList<WallViewItems>()
        for (i in 0 until size) {

            val item = WallViewItems("$i", wallURL[i])
            list += item
        }
        return list
    }
}