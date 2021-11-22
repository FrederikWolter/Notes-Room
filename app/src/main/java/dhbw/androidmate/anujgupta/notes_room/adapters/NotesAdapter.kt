package dhbw.androidmate.anujgupta.notes_room.adapters

import dhbw.androidmate.anujgupta.notes_room.ui.main.MainViewInterface
import dhbw.androidmate.anujgupta.notes_room.R
import android.support.v7.widget.RecyclerView
import dhbw.androidmate.anujgupta.notes_room.ui.add_note.AddNoteActivity
import dhbw.androidmate.anujgupta.notes_room.adapters.NotesAdapter
import dhbw.androidmate.anujgupta.notes_room.ui.add_note.AddNoteViewInterface
import dhbw.androidmate.anujgupta.notes_room.ui.main.MainActivity
import dhbw.androidmate.anujgupta.notes_room.adapters.NotesAdapter.NotesViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import dhbw.androidmate.anujgupta.notes_room.database.NoteDao
import dhbw.androidmate.anujgupta.notes_room.database.AppDatabase
import dhbw.androidmate.anujgupta.notes_room.models.Note
import android.content.Context
import dhbw.androidmate.anujgupta.notes_room.database.LocalCacheManager
import android.view.View
import java.util.ArrayList

class NotesAdapter(var context: Context?, noteList: MutableList<Note?>) : RecyclerView.Adapter<NotesViewHolder?>() {
    var noteList: MutableList<Note?> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NotesViewHolder? {
        val v: View = LayoutInflater.from(context).inflate(R.layout.row_note, parent, false)
        return NotesViewHolder(v)
    }

    override fun onBindViewHolder(holder: NotesViewHolder?, position: Int) {
        holder?.tvTitle?.setText(noteList[position]?.getTitle())
        holder?.tvNote?.setText(noteList[position]?.getNote())
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    inner class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView?
        var tvNote: TextView?

        init {
            tvTitle = itemView.findViewById(R.id.tvNoteTitle)
            tvNote = itemView.findViewById(R.id.tvNoteText)
        }
    }

    init {
        this.noteList = noteList
    }
}