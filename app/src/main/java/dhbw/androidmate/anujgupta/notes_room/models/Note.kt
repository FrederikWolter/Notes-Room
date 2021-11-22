package dhbw.androidmate.anujgupta.notes_room.models

import dhbw.androidmate.anujgupta.notes_room.ui.main.MainViewInterface
import dhbw.androidmate.anujgupta.notes_room.R
import dhbw.androidmate.anujgupta.notes_room.ui.add_note.AddNoteActivity
import dhbw.androidmate.anujgupta.notes_room.adapters.NotesAdapter
import dhbw.androidmate.anujgupta.notes_room.ui.add_note.AddNoteViewInterface
import dhbw.androidmate.anujgupta.notes_room.ui.main.MainActivity
import dhbw.androidmate.anujgupta.notes_room.adapters.NotesAdapter.NotesViewHolder
import dhbw.androidmate.anujgupta.notes_room.database.NoteDao
import dhbw.androidmate.anujgupta.notes_room.database.AppDatabase
import android.arch.persistence.room.*
import dhbw.androidmate.anujgupta.notes_room.database.LocalCacheManager

/**
 * Created by anujgupta on 13/01/18.
 */
@Entity(tableName = "notes")
class Note {
    @PrimaryKey(autoGenerate = true)
    private var id = 0

    @ColumnInfo(name = "title")
    private var title: String? = null

    @ColumnInfo(name = "note")
    private var note: String? = null

    constructor() {}
    constructor(id: Int, title: String?, note: String?) {
        this.id = id
        this.title = title
        this.note = note
    }

    constructor(title: String?, note: String?) {
        this.title = title
        this.note = note
    }

    fun getId(): Int {
        return id
    }

    fun getTitle(): String? {
        return title
    }

    fun getNote(): String? {
        return note
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun setNote(note: String?) {
        this.note = note
    }
}