package com.example.notelister

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ListItemViewer(
    item : ShoppingItems,
    onEditItem : () -> Unit,
    onDeleteItem : () -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically ,
        modifier = Modifier.padding(8.dp)
            .fillMaxWidth()
            .border(1.dp , MaterialTheme.colorScheme.onSurface , shape = CutCornerShape(8.dp))



    ) {
        Box(modifier = Modifier.weight(1f)){
            Text(
                text = item.Item_name,
                modifier = Modifier.padding(8.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }

        Box(modifier = Modifier.weight(1f)){
            Text(
                text = "Qty: ${item.Item_quantity}",
                modifier = Modifier.padding(8.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }

        Row {
            IconButton(onClick = onEditItem) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit Item")
            }

            IconButton(onClick = onDeleteItem) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Item")
            }
        }

    }
}











@Preview(showBackground = true , showSystemUi = true)
@Composable
fun ListItemViewerPreview(){
    ListItemViewer(
        item = ShoppingItems(
            id = 1,
            Item_name = "Milk",
            Item_quantity = 2
        ),
        onEditItem = {},
        onDeleteItem = {}
    )
}