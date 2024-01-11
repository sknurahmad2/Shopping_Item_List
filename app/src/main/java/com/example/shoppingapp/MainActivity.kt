package com.example.shoppingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.adapter.ShoppingItemAdapter
import com.example.shoppingapp.data.ShoppingItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items : List<ShoppingItem>

        val item1 = ShoppingItem("Nur",10);

        items = listOf(item1,item1,item1,item1,item1,item1,item1,item1,item1,item1,item1,item1,
            item1,ShoppingItem("Nyra",111))

        val adapter = ShoppingItemAdapter(items)
        val rvItem = findViewById<RecyclerView>(R.id.rv_shopping_items)
        rvItem.adapter = adapter
        rvItem.layoutManager = LinearLayoutManager(this)
    }
}