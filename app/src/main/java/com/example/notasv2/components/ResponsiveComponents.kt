// components/ResponsiveComponents.kt
package com.example.notasv2.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notasv2.ResponsiveScreen


@Composable
fun CompactLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Compact Layout", fontSize = 20.sp)
        // Agrega más elementos para este layout
    }
}

@Composable
fun ExpandedLayout() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Expanded Layout", fontSize = 24.sp)
        // Agrega más elementos para este layout
    }
}


@Composable
fun ResponsiveGrid(items: List<String>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(items) { item ->
            Text(
                text = item,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true, name = "Pantalla Compacta", widthDp = 320)
@Preview(showBackground = true, name = "Pantalla Expandida", widthDp = 800)
@Composable
fun PreviewResponsiveScreen() {
    ResponsiveScreen()
}

