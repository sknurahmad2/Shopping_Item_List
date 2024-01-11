package com.example.shoppingapp.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppingapp.repository.ShoppingRepository

@Suppress("UNCHECKED_CAST")
class ShoppingViewModelProviders(
    private val repository: ShoppingRepository
):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repository) as T
    }
}