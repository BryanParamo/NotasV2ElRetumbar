package com.example.notasv2

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.foundation.layout.Column


@OptIn(ExperimentalMaterial3Api::class) // Anotación para optar por las APIs experimentales
@Composable
fun BlocNotasScreen(navController: NavHostController, notesViewModel: NotesViewModel = viewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "BlocNotas") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("addNoteScreen") }, // Navegar a la pantalla de agregar nota
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Agregar Nota")
            }
        },
        content = { paddingValues ->
            NotesList(
                notes = notesViewModel.notes,
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}



@Composable
fun NotesList(notes: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize().padding(16.dp)
    ) {
        items(notes) { note ->
            var expanded by remember { mutableStateOf(false) }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = note,
                        fontSize = 18.sp,
                        modifier = Modifier.clickable { expanded = !expanded }
                    )

                    if (expanded) {
                        var textState by remember { mutableStateOf(note) }

                        BasicTextField(
                            value = textState,
                            onValueChange = { textState = it },
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }
        }
    }
}
