package com.example.documentlist.ui

import androidx.compose.Composable
import androidx.ui.material.ColorPalette
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Typography

@Composable
fun Theme(colors: ColorPalette, typography: Typography, children: @Composable() () -> Unit) {
    MaterialTheme(colors) {
        children()
    }
}