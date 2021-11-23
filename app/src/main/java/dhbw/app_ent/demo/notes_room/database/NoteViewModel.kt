package dhbw.app_ent.demo.notes_room.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import dhbw.app_ent.demo.notes_room.models.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val readAllData: LiveData<List<Note>>
    private val noteDao = AppDatabase.getAppDatabase(application).noteDao()

    init {
        readAllData = noteDao.getAll()
    }

    fun addNote(note: Note){
        viewModelScope.launch(Dispatchers.IO){
            noteDao.insertNote(note)
        }
    }
}