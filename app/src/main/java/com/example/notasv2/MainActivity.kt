package com.example.notasv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlocNotasScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BlocNotasScreen(notesViewModel: NotesViewModel = viewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "BlocNotas") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    notesViewModel.addNote("Nueva nota uwu")
                },
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

            // Material3 usa Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
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
                        var textState by remember { mutableStateOf(TextFieldValue(note)) }

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




