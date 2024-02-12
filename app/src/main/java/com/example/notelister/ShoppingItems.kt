package com.example.notelister

data class ShoppingItems(
    val id: Int,
    var Item_name: String,
    var Item_quantity: Long,
    var isEditing: Boolean = false

)
