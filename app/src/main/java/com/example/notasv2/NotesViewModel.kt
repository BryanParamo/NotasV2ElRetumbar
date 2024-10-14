package com.example.notasv2

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class NotesViewModel : ViewModel() {
    // Lista de notas
    var notes = mutableStateListOf<String>()
        private set

    // Método para agregar una nota
    fun addNote(note: String) {
        notes.add(note)
    }
}
