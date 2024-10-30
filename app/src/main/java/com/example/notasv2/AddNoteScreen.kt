import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notasv2.NotesViewModel
import java.util.*

@Composable
fun AddNoteScreen(navController: NavHostController, notesViewModel: NotesViewModel = viewModel()) {
    // Estados para título, descripción y fecha
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var isTask by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("") }

    // Contexto para mostrar el DatePickerDialog
    val context = LocalContext.current

    // Configuración del DatePickerDialog
    val calendar = Calendar.getInstance()
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, year: Int, month: Int, day: Int ->
            // Al seleccionar la fecha, la guardamos en formato "día/mes/año"
            selectedDate = "$day/${month + 1}/$year"
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Título de la nota") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Descripción de la nota") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Selector de tipo de nota/tarea
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "¿Es una tarea?")
            Switch(
                checked = isTask,
                onCheckedChange = { isTask = it }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Botón para abrir el DatePickerDialog
        Button(
            onClick = { datePickerDialog.show() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = if (selectedDate.isEmpty()) "Seleccionar fecha" else "Fecha: $selectedDate")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para agregar la nota y regresar a la pantalla principal
        Button(
            onClick = {
                // Agregar la nota al ViewModel con los detalles de título, descripción, tipo y fecha
                val noteType = if (isTask) "Tarea" else "Nota"
                val noteContent = "$noteType: $title - $description - Fecha: $selectedDate"
                notesViewModel.addNote(noteContent)
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Agregar Nota")
        }
    }
}
