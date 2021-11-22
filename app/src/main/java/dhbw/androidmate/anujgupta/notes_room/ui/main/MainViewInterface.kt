package dhbw.androidmate.anujgupta.notes_room.ui.main

import dhbw.androidmate.anujgupta.notes_room.ui.main.MainViewInterface
import dhbw.androidmate.anujgupta.notes_room.R
import dhbw.androidmate.anujgupta.notes_room.ui.add_note.AddNoteActivity
import dhbw.androidmate.anujgupta.notes_room.adapters.NotesAdapter
import dhbw.androidmate.anujgupta.notes_room.ui.add_note.AddNoteViewInterface
import dhbw.androidmate.anujgupta.notes_room.ui.main.MainActivity
import dhbw.androidmate.anujgupta.notes_room.adapters.NotesAdapter.NotesViewHolder
import dhbw.androidmate.anujgupta.notes_room.database.NoteDao
import dhbw.androidmate.anujgupta.notes_room.database.AppDatabase
import dhbw.androidmate.anujgupta.notes_room.models.Note
import dhbw.androidmate.anujgupta.notes_room.database.LocalCacheManager

/**
 * Created by anujgupta on 14/01/18.
 */
interface MainViewInterface {
    open fun onNotesLoaded(notes: MutableList<Note?>?)
    open fun onNoteAdded()
    open fun onDataNotAvailable()
}