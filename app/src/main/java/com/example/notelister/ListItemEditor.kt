package com.example.notelister

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notelister.ui.theme.NoteListerTheme

@Composable
fun ListItemEditor(
    items: ShoppingItems,
    onEditComplete: (String , Long) -> Unit
){
    var itemName by remember {
        mutableStateOf(items.Item_name)
    }

    var itemQuantity by remember {
        mutableStateOf(items.Item_quantity.toString())
    }

    var isEditing by remember {
        mutableStateOf(items.isEditing)
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.weight(2f)){

            BasicTextField(value = itemName,
                onValueChange = {
                        newString->
                    itemName = newString
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textStyle = TextStyle(color = MaterialTheme.colorScheme.onSurface , textDecoration = TextDecoration.Underline),


                )

            BasicTextField(value = itemQuantity,
                onValueChange = {
                        newQty->
                    itemQuantity = newQty
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textStyle = TextStyle(color = MaterialTheme.colorScheme.onSurface , textDecoration = TextDecoration.Underline)

            )
        }

        Button(onClick = {
            isEditing = false
            onEditComplete(itemName , itemQuantity.toLongOrNull()?:0) } , modifier = Modifier.weight(1f).padding(8.dp)){
            Text("Save")
        }
    }


}




@Preview(showBackground = true , showSystemUi = true)
@Composable
fun ListItemEditorPreview(){
    NoteListerTheme {
        ListItemEditor(
            items = ShoppingItems(
                id = 1,
                Item_name = "helldddddddddddddddddddddddddddddddddddd",
                Item_quantity = 2,
                isEditing = true
            ),
            onEditComplete = { itemName , itemQuantity ->

            }
        )
    }
}







