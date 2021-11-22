package dhbw.app_ent.demo.notes_room.ui.add_note


import butterknife.BindView
import dhbw.app_ent.demo.notes_room.R
import android.os.Bundle
import butterknife.ButterKnife
import dhbw.app_ent.demo.notes_room.database.LocalCacheManager
import android.content.Intent
import android.widget.Toast
import android.widget.EditText
import dhbw.app_ent.demo.notes_room.ui.main.MainActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

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
        val title = etTitle?.text.toString()
        val noteText = etNote?.text.toString()
        if (title == "" || noteText == "") {
            showToast("Please fill all the fields before saving")
        } else {
            //Call Method to add note
            LocalCacheManager.getInstance(this)?.addNotes(this, title, noteText)
        }
    }

    private fun showToast(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add_note, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
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