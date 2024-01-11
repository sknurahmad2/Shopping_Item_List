package com.example.shoppingapp.view_model

import androidx.lifecycle.ViewModel
import com.example.shoppingapp.data.ShoppingItem
import com.example.shoppingapp.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ShoppingViewModel(
    private val repository: ShoppingRepository
):ViewModel() {

    fun upsert(item:ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upSert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllItems() = repository.getAllItems()
}