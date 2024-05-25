package com.example.bookstoreapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookstoreapp.R
import androidx.compose.ui.res.painterResource

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.TopCenter) {
        Column {
            AuthorSection()
            DetailSection()
            ImageSection()
        }
    }
}

@Composable
fun AuthorSection() {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = 10.dp
        // elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column (modifier = Modifier.padding(10.dp)) {
            Row {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "")
                Text(
                    modifier = Modifier.padding(start = 6.dp),
                    text = stringResource(id = R.string.author),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )
                Spacer(modifier = Modifier.height(2.dp))

                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "")
                Text(
                    modifier = Modifier.padding(start = 6.dp),
                    text = stringResource(id = R.string.email),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Blue
                )
                Spacer(modifier = Modifier.height(2.dp))

                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = "")
                Text(
                    modifier = Modifier.padding(start = 6.dp),
                    text = stringResource(id = R.string.phone),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Blue
                )
            }
        }
    }
}

@Composable
fun DetailSection() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier.padding(start = 6.dp),
                    text = stringResource(id = R.string.app_title),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }
            Spacer(modifier = Modifier.height(2.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier.padding(start = 6.dp),
                    text = stringResource(id = R.string.showAllBook),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }
            Spacer(modifier = Modifier.height(2.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier.padding(start = 6.dp),
                    text = stringResource(id = R.string.addBook),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Blue
                )
            }
            Spacer(modifier = Modifier.height(2.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier.padding(start = 6.dp),
                    text = stringResource(id = R.string.findBook),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Blue
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
        }
    }
}

@Composable
fun ImageSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(240.dp)
                .clip(CircleShape)
                .border(3.dp, Color.Red, CircleShape),
            painter = painterResource(id = R.drawable.book),
            contentDescription = ""
        )
    }
}

@Preview(showBackground = true)
@Composable
fun hd() {
    HomeScreen()
}