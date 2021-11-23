package dhbw.app_ent.demo.notes_room.database

import androidx.lifecycle.LiveData
import dhbw.app_ent.demo.notes_room.models.Note
import androidx.room.*

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getAll(): LiveData<List<Note>>

    @Insert
    suspend fun insertAll(vararg notes: Note?)

    @Insert
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}