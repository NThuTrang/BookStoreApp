package com.example.bookstoreapp.screens

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.core.content.ContextCompat
import com.example.bookstoreapp.model.Book
import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.graphics.*
import android.graphics.pdf.PdfDocument
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bookstoreapp.R

@Composable
fun PdfScreen(book: Book) {
    val context = LocalContext.current
    val activity = LocalContext.current as Activity

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp),
            colors = ButtonDefaults.buttonColors(Color.Red),
            onClick = {
                generatePDF(context, book)
            }) {
            Text(
                text = "Generate PDF file",
                textAlign = TextAlign.Center,
                color = Color.Yellow
            )
        }
    }
}

fun generatePDF(context: Context, book: Book) {
    val pageHeight = 1120
    val pageWidth = 800

    var bmp: Bitmap
    var scalebmp: Bitmap

    val pdfDocument = PdfDocument()
    val paint = Paint()
    val title = Paint()

    bmp = BitmapFactory.decodeResource(context.resources, R.drawable.book)
    scalebmp = Bitmap.createScaledBitmap(bmp, 120, 120, false)

    val myPageInfo: PdfDocument.PageInfo? =
        PdfDocument.PageInfo.Builder(pageWidth, pageHeight, 1).create()
    val myPage: PdfDocument.Page = pdfDocument.startPage(myPageInfo)
    val canvas: Canvas = myPage.canvas
    var fileName = ""

    // vẽ hình book
    canvas.drawBitmap(scalebmp, 56F, 40F, paint)
    // định dạng font chữ
    title.typeface = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL)
    title.textSize = 15F
    title.color = ContextCompat.getColor(context, R.color.purple_200)

    // tạo filename theo ID
    book.id?.let {
        fileName = "${it}book.pdf"
    }

    // in title của book
    book.title?.let {
        canvas.drawText("Title: $it", 210F, 60F, title)
    }
    // in author
    book.author?.let {
        canvas.drawText("Author: $it", 210F, 80F, title)
    }
    // in desciption
    book.description?.let {
        canvas.drawText("Description: $it", 210F, 100F, title)
    }

}

// hàm kiểm tra quyền đọc/ ghi
@Composable
fun checkPermission(context: Context): Boolean {
    // quyền write
    val write = ContextCompat.checkSelfPermission(
        context, Manifest.permission.WRITE_EXTERNAL_STORAGE
    ) == PackageManager.PERMISSION_GRANTED
    val read = ContextCompat.checkSelfPermission(
        context, Manifest.permission.READ_EXTERNAL_STORAGE
    ) == PackageManager.PERMISSION_GRANTED

    return write && read
}

// hàm yêu cầu cấp quyền
fun requestPermission(activity: Activity) {
    activity
    arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
}