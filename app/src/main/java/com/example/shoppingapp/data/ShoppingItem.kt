package com.example.shoppingapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.temporal.TemporalAmount

//@Entity(tableName = "shopping_table")
data class ShoppingItem(
//    @PrimaryKey(autoGenerate = true)
//    var id:Int? = null,
//    @ColumnInfo("itemName")
    var itemName:String?,
//    @ColumnInfo("itemAmount")
    var itemAmount: Int
)
