package com.landfathich.moneychecker

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.name)
        val price = findViewById<EditText>(R.id.price)
        val add = findViewById<Button>(R.id.add)
        val recyclerView = findViewById<RecyclerView>(R.id.items)

        val adapter = ProductAdapter(arrayListOf())
        recyclerView.adapter = adapter

        add.setOnClickListener {
            adapter.data.add(
                Product(name.text.toString(), price.text.toString())
            )
            adapter.notifyItemInserted(adapter.data.size - 1)
        }
    }
}