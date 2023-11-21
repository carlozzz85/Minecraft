package com.cst2335.week5

import android.os.Bundle
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cst2335.week5.ui.theme.Week5Theme
import java.lang.Exception
import org.json.JSONArray;
import org.json.JSONException;


class MainActivity : ComponentActivity() {

    private lateinit var entityListView: ListView
    private val entityList = mutableListOf<Entity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        entityListView = findViewById(R.id.entityListView)

        loadJSONFromAsset()
        val adapter = EntityAdapter(this, entityList)
        entityListView.adapter =adapter

    }
    private fun loadJSONFromAsset(){
        try{
            val jsonContent = assets.open("entities.json").bufferedReader().use {it.readText()}
            val jsonArray =JSONArray(jsonContent)
            for(i in 0 until jsonArray.length()){
                val jsonObject = jsonArray.getJSONObject(i)
                val entity = Entity(
                    jsonObject.getInt("type"),
                    jsonObject.getString("name"),
                    jsonObject.getString("text_type")
                )
                entityList.add(entity)
            }
        } catch (e: Exception){
            e.printStackTrace()
        }
    }
}

