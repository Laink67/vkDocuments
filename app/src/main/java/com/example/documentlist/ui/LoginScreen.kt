package com.example.documentlist.ui

import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.HeightSpacer
import androidx.ui.material.TopAppBar
import com.example.documentlist.model.VKDocs

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
            VerticalScroller {
                Column {
                    HeightSpacer(16.dp)
                    docs.forEach { user ->
                        Text(user.title)
                    }
                }
            }
        }

    }
}
