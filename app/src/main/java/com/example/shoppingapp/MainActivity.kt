package com.example.shoppingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.adapter.ShoppingItemAdapter
import com.example.shoppingapp.data.ShoppingDatabase
import com.example.shoppingapp.data.ShoppingItem
import com.example.shoppingapp.dialoge.AddDialogListener
import com.example.shoppingapp.dialoge.AddShoppingItemDialog
import com.example.shoppingapp.repository.ShoppingRepository
import com.example.shoppingapp.view_model.ShoppingViewModel
import com.example.shoppingapp.view_model.ShoppingViewModelProviders
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val item1 =
//        val list = listOf<ShoppingItem>(ShoppingItem("Nur",10)
        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelProviders(repository)
        val viewMOdel = ViewModelProviders.of(this,factory).get(ShoppingViewModel::class.java)

        var adapter = ShoppingItemAdapter(listOf(),viewMOdel)
        val rv_shopping_itmes = findViewById<RecyclerView>(R.id.rv_shopping_items)
        rv_shopping_itmes.layoutManager = LinearLayoutManager(this)
        rv_shopping_itmes.adapter = adapter

        viewMOdel.getAllItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        findViewById<FloatingActionButton>(R.id.fab_btn).setOnClickListener {
            AddShoppingItemDialog(this,
                object :AddDialogListener{
                    override fun onAddButtonClicked(item: ShoppingItem) {
                        viewMOdel.upsert(item)
                    }
                }
            ).show()
        }
    }
}