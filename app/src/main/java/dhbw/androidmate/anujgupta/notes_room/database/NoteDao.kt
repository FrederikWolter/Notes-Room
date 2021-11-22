package dhbw.androidmate.anujgupta.notes_room.database

import dhbw.androidmate.anujgupta.notes_room.ui.main.MainViewInterface
import dhbw.androidmate.anujgupta.notes_room.R
import dhbw.androidmate.anujgupta.notes_room.ui.add_note.AddNoteActivity
import dhbw.androidmate.anujgupta.notes_room.adapters.NotesAdapter
import dhbw.androidmate.anujgupta.notes_room.ui.add_note.AddNoteViewInterface
import dhbw.androidmate.anujgupta.notes_room.ui.main.MainActivity
import dhbw.androidmate.anujgupta.notes_room.adapters.NotesAdapter.NotesViewHolder
import io.reactivex.Maybe
import dhbw.androidmate.anujgupta.notes_room.database.NoteDao
import dhbw.androidmate.anujgupta.notes_room.database.AppDatabase
import dhbw.androidmate.anujgupta.notes_room.models.Note
import android.arch.persistence.room.*
import dhbw.androidmate.anujgupta.notes_room.database.LocalCacheManager

/**
 * Created by anujgupta on 13/01/18.
 */
@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    open fun getAll(): Maybe<MutableList<Note?>?>?
    @Insert
    open fun insertAll(vararg notes: Note?)
}