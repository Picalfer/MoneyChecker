package com.landfathich.moneychecker

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query


class MainActivity : AppCompatActivity() {

    private lateinit var dbRef: DatabaseReference
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = FirebaseDatabase.getInstance()
        database.setPersistenceEnabled(true)
        dbRef = database.getReference("items")
            .child("users")
            .child("thisUser")
        // здесь вместо thisUser можно создавать специально
        // для этого пользователя ветку с базой данных

        val name = findViewById<EditText>(R.id.name)
        val price = findViewById<EditText>(R.id.price)
        val add = findViewById<Button>(R.id.add)
        val recyclerView = findViewById<RecyclerView>(R.id.items)

        // dbRef.removeValue()

        val adapter = ProductAdapter(arrayListOf())
        recyclerView.adapter = adapter

        val myQuery: Query = dbRef.orderByChild("price")
        myQuery.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, s: String?) {
                val item = dataSnapshot.getValue(Product::class.java)
                if (item != null) {
                    adapter.data.add(item)
                    adapter.notifyItemInserted(adapter.data.size - 1)
                }
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, s: String?) {}
            override fun onChildRemoved(dataSnapshot: DataSnapshot) {}
            override fun onChildMoved(dataSnapshot: DataSnapshot, s: String?) {}
            override fun onCancelled(databaseError: DatabaseError) {}
        })

        add.setOnClickListener {
            val product = Product(name.text.toString(), price.text.toString().toInt())
            dbRef.push().setValue(product)
        }
    }
}