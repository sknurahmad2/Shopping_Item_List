package com.example.shoppingapp.dialoge

import com.example.shoppingapp.data.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}