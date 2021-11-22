package dhbw.app_ent.demo.notes_room.adapters

import dhbw.app_ent.demo.notes_room.R
import dhbw.app_ent.demo.notes_room.adapters.NotesAdapter.NotesViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import dhbw.app_ent.demo.notes_room.models.Note
import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class NotesAdapter(var context: Context?, noteList: MutableList<Note?>) : RecyclerView.Adapter<NotesViewHolder?>() {
    var noteList: MutableList<Note?> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val v: View = LayoutInflater.from(context).inflate(R.layout.row_note, parent, false)
        return NotesViewHolder(v)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.tvTitle?.text = noteList[position]?.getTitle()
        holder.tvNote?.text = noteList[position]?.getNote()
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    inner class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView? = itemView.findViewById(R.id.tvNoteTitle)
        var tvNote: TextView? = itemView.findViewById(R.id.tvNoteText)
    }

    init {
        this.noteList = noteList
    }
}