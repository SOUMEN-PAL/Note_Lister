package com.example.notelister

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


fun isPalindrome(word: String): Boolean{
    var i = 0
    var j = word.length - 1
    while (i < j){
        if (word[i] != word[j]){
            return false
        }
        i++
        j--
    }
    return true
}

@Composable
fun PalindromeChecker(){
    val context = LocalContext.current
    var word = remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize() , horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Plindrome Checker" , modifier = Modifier.padding(top = 100.dp , bottom = 16.dp))

        OutlinedTextField(value = word.value, onValueChange = {
            word.value = it
        },
            label = { Text(text = "Enter a word")}
        )

        Button(onClick = {
                         if(isPalindrome(word.value)){
                            Toast.makeText(context , "${word.value} is a palindrome" , Toast.LENGTH_LONG).show()
                         }else{
                            Toast.makeText(context , "${word.value} is not a palindromee" , Toast.LENGTH_LONG).show()
                         }
        } , modifier = Modifier.padding(top = 16.dp , bottom = 16.dp)){
            Text(text = "Check")
        }
    }

}


@Preview(showBackground = true)
@Composable

fun PreviewPalindromeChecker(){

    PalindromeChecker()

}