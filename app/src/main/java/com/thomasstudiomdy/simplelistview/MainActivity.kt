package com.thomasstudiomdy.simplelistview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1 - Adapter View: ListView

        val listView:ListView = findViewById(R.id.listView)

        // 2 - Data Source: Array of Strings
        val worldCupArray = arrayOf("Germany","Brazil","England","Spain","Qatar")

        // 3 - Adapter
        val arrayAdapter: ArrayAdapter<*>
        arrayAdapter = ArrayAdapter(
            this,
            R.layout.test_item,
            R.id.textView,
            worldCupArray

        )

        listView.adapter = arrayAdapter

    }
}