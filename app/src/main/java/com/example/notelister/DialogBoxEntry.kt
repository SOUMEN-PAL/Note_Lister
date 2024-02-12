package com.example.notelister

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun DialogBoxEntry(
    showDialog : Boolean,
    onDismiss : () -> Unit,
    onAdd : () -> Unit,
    onCancel : () -> Unit,
    itemName : String,
    onItemNameChange : (String) -> Unit,
    itemQuantity : String,
    onItemQuantityChange : (String) -> Unit
){
    if(showDialog){
        AlertDialog(onDismissRequest = onDismiss,
            confirmButton = {

                Row(modifier = Modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.SpaceBetween){


                    Button(onClick = onAdd) {
                        Text(text = "Add")
                    }

                    Button(onClick = onCancel) {
                        Text(text = "Cancel")
                    }
                }



            },


            title = { Text(text = "Add Item" , fontSize = 20.sp) },

            text = {
                Column {
                    OutlinedTextField(value = itemName,
                        onValueChange = onItemNameChange,
                        label = { Text("Item Name") },
                        singleLine = true
                    )

                    OutlinedTextField(value = itemQuantity,
                        onValueChange = onItemQuantityChange,
                        label = { Text("Item Quanttity") },
                        singleLine = true
                    )

                }


            },
            shape = CutCornerShape(8.dp),

        )

    }


}


@Preview(showBackground = true)
@Composable
fun DialogBoxEntryPreview(){
    DialogBoxEntry(
        showDialog = true,
        onDismiss = {  },
        onAdd = {  },
        onCancel = {  },
        itemName = "Item Name",
        onItemNameChange = {  },
        itemQuantity = "Item Quantity",
        onItemQuantityChange = {  }
    )
}