package com.example.documentlist.ui

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.border.Border
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.layout.Size
import androidx.ui.material.*
import androidx.ui.material.ripple.Ripple
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import com.example.documentlist.R
import com.example.documentlist.model.VKDocs
import com.example.documentlist.util.SizeFormatter
import java.text.SimpleDateFormat
import java.util.*


@Composable
fun LoginScreen(docs: List<VKDocs>) {
    Theme(colors = lightThemeColors, typography = themeTypography, children = { Body(docs) })
}

@Composable
private fun Body(docs: List<VKDocs>) {
    Column {
        TopAppBar(
            title = { Text("Документы") }
        )
        Column {
            VerticalScroller(modifier = Flexible(1f)) {
                Column {
                    HeightSpacer(16.dp)
                    docs.forEach { doc ->
                        PostCardSimple(doc)
                    }
                }
            }
        }
    }
}

@Composable
fun PostCardSimple(doc: VKDocs) {
    val image = +imageResource(R.drawable.ic_more_vertical_16)

    Ripple(bounded = true) {
        Clickable(onClick = {
            //            navigateTo(Screen.Article(post.id))
        }) {
            Row(modifier = Spacing(8.dp)) {
                PostImage(modifier = Spacing(right = 12.dp))
                Column(modifier = Flexible(1f)) {
                    PostTitle(doc)
                    AuthorAndReadTime(doc)
                }
                Opacity(opacity = 0.35f) {
                    Button(
                        modifier = Gravity.Center
                                wraps Spacing(right = 16.dp)
                                wraps Size(
                            height = 16.dp,
                            width = 8.dp
                        ),
                        style = OutlinedButtonStyle(
                            color = Color.Transparent,
                            border = Border(Color.Transparent, 0.dp),
                            shape = (+MaterialTheme.shapes()).button
                        )
                    ) {
                        Clickable(onClick = {})
                        {
                            DrawImage(image = image)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PostImage(modifier: Modifier = Modifier.None) {
    val image = +imageResource(R.drawable.ic_placeholder_document_archive_72)

    Container(modifier = modifier wraps Size(72.dp, 72.dp)) {
        Clip(RoundedCornerShape(8.dp)) {
            DrawImage(image)
        }
    }
}

@Composable
fun PostTitle(doc: VKDocs) {
    Text(doc.title, style = ((+MaterialTheme.typography()).subtitle1).withOpacity(0.87f))
}

@Composable
fun AuthorAndReadTime(doc: VKDocs) {
    val sizeFormatter = SizeFormatter()
    val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm  ")
    sdf.timeZone = TimeZone.getTimeZone("GMT-4")
//    val sdf = java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")

    Row {
        val textStyle = ((+MaterialTheme.typography()).body2).withOpacity(0.6f)

        Text(
            sdf.format(doc.date * 1000L),
            style = textStyle
        )
        Text(
            text = sizeFormatter.format(doc.size),
            style = textStyle
        )
    }
}

@Preview
@Composable
fun preview() {
    PostCardSimple(doc = VKDocs(0, "WtF", 1000, "pdf", 4231415))
}

