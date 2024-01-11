package com.example.shoppingapp.repository

import com.example.shoppingapp.data.ShoppingDatabase
import com.example.shoppingapp.data.ShoppingItem

class ShoppingRepository(
    private val db:ShoppingDatabase
) {

    suspend fun upSert(item: ShoppingItem) = db.getShoppingDao().upSert(item)

    suspend fun delete(item:ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllItems() = db.getShoppingDao().getAllItems()
}