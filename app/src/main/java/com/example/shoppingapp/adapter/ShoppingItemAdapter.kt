package com.example.shoppingapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.MainActivity
import com.example.shoppingapp.R
import com.example.shoppingapp.data.ShoppingItem
import com.example.shoppingapp.view_model.ShoppingViewModel

class ShoppingItemAdapter(
    var items:List<ShoppingItem>,
    val viewModel:ShoppingViewModel
):RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shopping,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]

        holder.itemView.findViewById<TextView>(R.id.tvName).text = curShoppingItem.itemName
        holder.itemView.findViewById<TextView>(R.id.tvAmount).text = curShoppingItem.itemAmount.toString()

        holder.itemView.findViewById<ImageView>(R.id.ivAdd).setOnClickListener {
            curShoppingItem.itemAmount++
            viewModel.upsert(curShoppingItem)
        }

        holder.itemView.findViewById<ImageView>(R.id.ivMinus).setOnClickListener {
            if(curShoppingItem.itemAmount>0){
                curShoppingItem.itemAmount--
                viewModel.upsert(curShoppingItem)
            }
        }

        holder.itemView.findViewById<ImageView>(R.id.ivDelete).setOnClickListener {
            viewModel.delete(curShoppingItem)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingViewHolder (itemView:View):RecyclerView.ViewHolder(itemView)

}