package com.example.notasv2

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf

class NotesViewModel : ViewModel() {
    // Lista de notas utilizando un estado mutable
    var notes = mutableStateListOf<String>()

    fun addNote(note: String) {
        notes.add(note) // Agrega la nueva nota a la lista
    }
}


