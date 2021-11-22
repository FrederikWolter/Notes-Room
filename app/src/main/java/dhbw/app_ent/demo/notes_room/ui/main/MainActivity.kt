package dhbw.app_ent.demo.notes_room.ui.main

import butterknife.BindView
import dhbw.app_ent.demo.notes_room.R
import android.os.Bundle
import butterknife.ButterKnife
import dhbw.app_ent.demo.notes_room.database.LocalCacheManager
import butterknife.OnClick
import android.content.Intent
import dhbw.app_ent.demo.notes_room.ui.add_note.AddNoteActivity
import dhbw.app_ent.demo.notes_room.adapters.NotesAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dhbw.app_ent.demo.notes_room.models.Note

class MainActivity : AppCompatActivity(), MainViewInterface {
    @JvmField
    @BindView(R.id.rvNotes)
    var rvNotes: RecyclerView? = null
    private var adapter: RecyclerView.Adapter<*>? = null
    private var notesList: MutableList<Note?>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        initViews()
        loadNotes()
    }

    private fun initViews() {
        rvNotes?.layoutManager = LinearLayoutManager(this)
    }

    private fun loadNotes() {

        //Call Method to get Notes
        LocalCacheManager.getInstance(this)?.getNotes(this)
    }

    @OnClick(R.id.fabAddNote)
    fun addNote() {
        val i = Intent(this@MainActivity, AddNoteActivity::class.java)
        startActivity(i)
    }

    override fun onNotesLoaded(notes: MutableList<Note?>?) {
        notesList = notes
        if (notesList?.size == 0) {
            onDataNotAvailable()
        } else {
            adapter = notes?.let { NotesAdapter(this, it) }
            rvNotes?.adapter = adapter
        }
    }

    override fun onNoteAdded() {
        Toast.makeText(this, "Note Added", Toast.LENGTH_SHORT).show()
    }

    override fun onDataNotAvailable() {
        Toast.makeText(this, "No Notes Yet", Toast.LENGTH_SHORT).show()
    }
}