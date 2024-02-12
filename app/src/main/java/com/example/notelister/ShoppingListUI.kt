package com.example.notelister


import android.widget.Toast

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.notelister.ui.theme.NoteListerTheme



@Composable
fun ShoppingListUI(){

    var sItems by remember {
        mutableStateOf(listOf<ShoppingItems>())
    }

    var showDialog by remember{
        mutableStateOf(false)
    }

    var itemName by remember {
        mutableStateOf("")
    }

    var itemQuantity by remember{
        mutableStateOf("")
    }




    Column(horizontalAlignment = Alignment.CenterHorizontally , modifier = Modifier.fillMaxSize()) {



        Button(onClick = { showDialog = true } , modifier = Modifier.padding(16.dp)){
            Text(text = "Add Item")
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
            ){

            items(sItems){
                item ->
                if(item.isEditing){
                    ListItemEditor(
                        items = item,
                        onEditComplete = {
                            newName , newQty ->
                            sItems = sItems.map{
                                it.copy(isEditing = false)
                            }
                            val editedItem = sItems.find { it.id == item.id }
                            editedItem?.let {
                                it.Item_name = newName
                                it.Item_quantity = newQty
                            }
                        }
                    )
                }else{
                    ListItemViewer(item = item, onEditItem = { sItems = sItems.map { it.copy(isEditing = it.id == item.id) } } , onDeleteItem = {sItems = sItems - item})
                }

            }




        }




    }
    val context = LocalContext.current
    DialogBoxEntry(
        showDialog = showDialog,
        onDismiss = { showDialog = false},
        onAdd = {
                if(itemName.isNotEmpty() && itemQuantity.isNotEmpty()){
                    val newItem = ShoppingItems(
                        id = sItems.size + 1,
                        Item_name = itemName,
                        Item_quantity = itemQuantity.toLongOrNull() ?: 0
                    )
                    sItems = sItems.plus(newItem)
                    showDialog = false
                    itemName = ""
                    itemQuantity = ""
                }else{
                    Toast.makeText( context , "Please enter a valid item name and quantity" , Toast.LENGTH_SHORT).show()
                }
        },
        onCancel = { showDialog = false},
        itemName = itemName,
        onItemNameChange = { itemName = it },
        itemQuantity = itemQuantity,
        onItemQuantityChange = { itemQuantity = it }
    )


}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteListerTheme {
        ShoppingListUI()
    }
}