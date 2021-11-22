package dhbw.androidmate.anujgupta.notes_room

import kotlin.Throws
import dhbw.androidmate.anujgupta.notes_room.ui.main.MainViewInterface
import dhbw.androidmate.anujgupta.notes_room.R
import dhbw.androidmate.anujgupta.notes_room.ui.add_note.AddNoteActivity
import dhbw.androidmate.anujgupta.notes_room.adapters.NotesAdapter
import dhbw.androidmate.anujgupta.notes_room.ui.add_note.AddNoteViewInterface
import dhbw.androidmate.anujgupta.notes_room.ui.main.MainActivity
import dhbw.androidmate.anujgupta.notes_room.adapters.NotesAdapter.NotesViewHolder
import dhbw.androidmate.anujgupta.notes_room.database.NoteDao
import dhbw.androidmate.anujgupta.notes_room.database.AppDatabase
import dhbw.androidmate.anujgupta.notes_room.database.LocalCacheManager
import org.junit.Assert
import org.junit.Test
import java.lang.Exception

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        Assert.assertEquals(4, (2 + 2).toLong())
    }
}