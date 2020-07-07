package com.hitesh.summerwalls

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.hitesh.summerwalls.adapter.WallAdapter
import com.hitesh.summerwalls.repository.WallsData
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


class MainActivity : AppCompatActivity() {

    var wallsData: WallsData? = null
    var requestQueue: RequestQueue? = null
    var jsonUrl = "https://gist.githubusercontent.com/hiteshhv/38dfff56a782089471e5ada9a7a2bb7f/raw/a9234b2eacc4aafb9b9b20bc1a434fadb8220a51/walls.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestQueue = Volley.newRequestQueue(this)

        val wallItemsList = parseJson()
        walls_adapter.adapter = WallAdapter(wallItemsList!!)
        walls_adapter.layoutManager = GridLayoutManager(applicationContext, 2)
        walls_adapter.setHasFixedSize(true)
    }

    fun parseJson(): List<WallViewItems>{
        val jsonList = ArrayList<WallViewItems>()
        var jsonObjectRequest = JsonObjectRequest(Request.Method.GET, jsonUrl, null,
            Response.Listener { response ->

                var jsonArray = response.getJSONArray("walls")
                for (i in 0 until jsonArray.length()) {
                    val employee: JSONObject = jsonArray.getJSONObject(i)
                    val title = employee.getString("title")
                    val url = employee.getString("url")
                    val jsonItem = WallViewItems(title, url)
                    jsonList += jsonItem
                    Toast.makeText(applicationContext, "$title and $url", Toast.LENGTH_SHORT).show()
                }
            },
            Response.ErrorListener { error ->
            })
        requestQueue?.add(jsonObjectRequest)
        return  jsonList
    }
}
