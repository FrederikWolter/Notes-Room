package dhbw.androidmate.anujgupta.notes_room.database

import dhbw.androidmate.anujgupta.notes_room.ui.main.MainViewInterface
import dhbw.androidmate.anujgupta.notes_room.R
import dhbw.androidmate.anujgupta.notes_room.ui.add_note.AddNoteActivity
import dhbw.androidmate.anujgupta.notes_room.adapters.NotesAdapter
import dhbw.androidmate.anujgupta.notes_room.ui.add_note.AddNoteViewInterface
import dhbw.androidmate.anujgupta.notes_room.ui.main.MainActivity
import dhbw.androidmate.anujgupta.notes_room.adapters.NotesAdapter.NotesViewHolder
import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import dhbw.androidmate.anujgupta.notes_room.database.NoteDao
import dhbw.androidmate.anujgupta.notes_room.database.AppDatabase
import dhbw.androidmate.anujgupta.notes_room.models.Note
import android.arch.persistence.room.Room
import android.content.Context
import dhbw.androidmate.anujgupta.notes_room.database.LocalCacheManager

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao?

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getAppDatabase(context: Context?): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context!!.getApplicationContext(), AppDatabase::class.java, "database-name")
                        .build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}