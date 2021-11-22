package dhbw.app_ent.demo.notes_room.ui.main

import dhbw.app_ent.demo.notes_room.models.Note

interface MainViewInterface {
    open fun onNotesLoaded(notes: MutableList<Note?>?)
    open fun onNoteAdded()
    open fun onDataNotAvailable()
}