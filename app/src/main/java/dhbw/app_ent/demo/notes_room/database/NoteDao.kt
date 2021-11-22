package dhbw.app_ent.demo.notes_room.database

import io.reactivex.Maybe
import dhbw.app_ent.demo.notes_room.models.Note
import androidx.room.*


@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getAll(): Maybe<MutableList<Note?>?>?

    @Insert
    fun insertAll(vararg notes: Note?)

    @Insert
    fun insertNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)
}