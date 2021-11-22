package dhbw.androidmate.anujgupta.notes_room.ui.add_note

import android.support.v7.app.AppCompatActivity
import dhbw.androidmate.anujgupta.notes_room.ui.main.MainViewInterface
import butterknife.BindView
import dhbw.androidmate.anujgupta.notes_room.R
import android.os.Bundle
import butterknife.ButterKnife
import dhbw.androidmate.anujgupta.notes_room.database.LocalCacheManager
import android.content.Intent
import dhbw.androidmate.anujgupta.notes_room.ui.add_note.AddNoteActivity
import dhbw.androidmate.anujgupta.notes_room.adapters.NotesAdapter
import android.widget.Toast
import dhbw.androidmate.anujgupta.notes_room.ui.add_note.AddNoteViewInterface
import android.widget.EditText
import dhbw.androidmate.anujgupta.notes_room.ui.main.MainActivity
import dhbw.androidmate.anujgupta.notes_room.adapters.NotesAdapter.NotesViewHolder
import dhbw.androidmate.anujgupta.notes_room.database.NoteDao
import dhbw.androidmate.anujgupta.notes_room.database.AppDatabase
import android.view.Menu
import android.view.MenuItem

class AddNoteActivity : AppCompatActivity(), AddNoteViewInterface {
    @JvmField
    @BindView(R.id.etTitle)
    var etTitle: EditText? = null

    @JvmField
    @BindView(R.id.etNote)
    var etNote: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        ButterKnife.bind(this)
    }

    private fun saveNote() {
        val title = etTitle?.getText().toString()
        val note_text = etNote?.getText().toString()
        if (title == "" || note_text == "") {
            showToast("Please fill all the fields before saving")
        } else {
            //Call Method to add note
            LocalCacheManager.Companion.getInstance(this)?.addNotes(this, title, note_text)
        }
    }

    private fun showToast(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_note, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.getItemId()
        if (id == R.id.action_save) {
            saveNote()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNoteAdded() {
        Toast.makeText(this, "Note Added", Toast.LENGTH_SHORT).show()
        val i = Intent(this@AddNoteActivity, MainActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(i)
    }

    override fun onDataNotAvailable() {
        Toast.makeText(this, "Could not add note", Toast.LENGTH_SHORT).show()
    }
}