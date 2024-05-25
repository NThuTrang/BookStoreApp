package com.example.bookstoreapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookstoreapp.methods.addBook
import com.example.bookstoreapp.model.Book
import com.example.bookstoreapp.ui.theme.bg1
import com.example.bookstoreapp.ui.theme.bg2

@Composable
fun AddScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        bg1, bg2
                    )
                )
            ),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Add Book",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(20.dp))
            // gọi màn hình Add
            Add()
        }
    }
}

@Composable
fun Add() {
    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var imagefile by remember { mutableStateOf("") }
    var addResult by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // ô nhập title
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = { title = it },
            label = { Text(text = "Title")},
            textStyle = TextStyle(color = Color.White),
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )
        // ô nhập author
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = author,
            onValueChange = { author = it },
            label = { Text(text = "Author")},
            textStyle = TextStyle(color = Color.White),
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )
        // ô nhập description: chưa sửa
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = description,
            onValueChange = { description = it },
            label = { Text(text = "Description")},
            textStyle = TextStyle(color = Color.White),
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Info, contentDescription = "")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )
        // ô nhập imagefile
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = imagefile,
            onValueChange = { imagefile = it },
            label = { Text(text = "Image File") },
            textStyle = TextStyle(color = Color.White),
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )
        // nút save
        OutlinedButton(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp),
            colors = ButtonDefaults.buttonColors(Color.Yellow),
            onClick = {
                val b = Book(0, title, description, author, imagefile )
                // gọi hàm và nhận kết quả callback
                addBook(b) {
                    addResult = it
                }
            }) {
                Text(text = "Save", textAlign = TextAlign.Center, color = Color.Red)
        }
        if (addResult) {
            Text(text = "Success", textAlign = TextAlign.Center, color = Color.Red)
        }
    }
}