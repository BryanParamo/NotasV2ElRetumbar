package com.example.notasv2

import AddNoteScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.notasv2.components.CompactLayout
import com.example.notasv2.components.ExpandedLayout


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlocNotasApp() // Inicia el flujo de navegación aquí
        }
    }
}



@Composable
fun ResponsiveScreen() {
    BoxWithConstraints {
        if (maxWidth < 600.dp) {
            CompactLayout() // Llámalo con tus funciones para pantallas pequeñas
        } else {
            ExpandedLayout() // Llámalo con funciones para pantallas grandes
        }
    }
}

@Composable
fun BlocNotasApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen") { BlocNotasScreen(navController) }
        composable("addNoteScreen") { AddNoteScreen(navController) }
    }
}

