package dhbw.app_ent.demo.notes_room.models

import androidx.room.*

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