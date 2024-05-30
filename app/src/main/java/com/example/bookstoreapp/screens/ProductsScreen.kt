package com.example.bookstoreapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookstoreapp.methods.getBooks
import com.example.bookstoreapp.model.Book
import com.example.bookstoreapp.ui.theme.bg1
import com.example.bookstoreapp.ui.theme.bg2
private const val URL_IMAGE = "http://172.20.10.2/ltweb/chuong_14/duan_demo/uploads/"
@Composable
fun ProductsScreen() {
    var list by remember { mutableStateOf(mutableStateListOf<Book>()) }
    // nhận kết quả từ callback
    getBooks {
        list = it
    }
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
        Text(
            text = "Products",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        // gọi hàm trình bày các book
        showBooks(list = list)
    }
}

// hàm đọc và hiển thị sách
@Composable
fun showBooks(list: MutableList<Book>) {
    LazyColumn(
        contentPadding = PaddingValues(all = 6.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        items(list) { book ->
            BookItemImage(book = Book())
        }
    }
}

// hàm hiển thị từng quyển sách
@Composable
fun BookItem(book: Book) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            modifier = Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(8.dp))
                .background(Color.LightGray)
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                book.title?.let {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Star, contentDescription = "")
                        Column() {
                            Text(
                                modifier = Modifier.padding(start = 6.dp),
                                text = "ID: ${book.id}",
                                color = Color.Red,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                modifier = Modifier.padding(start = 6.dp),
                                text = it,
                                color = Color.Blue,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
                book.author?.let {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "")
                        Text(
                            modifier = Modifier.padding(start = 6.dp),
                            text = "ID: ${book.id}",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
                book.description?.let {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "")
                        Text(
                            modifier = Modifier.padding(start = 6.dp),
                            text = "ID: ${book.id}",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BookItemImage(book: Book) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            modifier = Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(8.dp))
                .background(Color.LightGray)
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                book.title?.let {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Star, contentDescription = "")
                        Column() {
                            Text(
                                modifier = Modifier.padding(start = 6.dp),
                                text = "ID: ${book.id}",
                                color = Color.Red,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                modifier = Modifier.padding(start = 6.dp),
                                text = it,
                                color = Color.Blue,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
                book.author?.let {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "")
                        Text(
                            modifier = Modifier.padding(start = 6.dp),
                            text = "ID: ${book.id}",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
                book.description?.let {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "")
                        Text(
                            modifier = Modifier.padding(start = 6.dp),
                            text = "ID: ${book.id}",
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun Prod() {
//    ProductsScreen()
//}
