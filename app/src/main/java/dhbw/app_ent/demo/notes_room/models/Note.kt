package dhbw.app_ent.demo.notes_room.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note (
        @PrimaryKey(autoGenerate = true)    val id: Int,
        @ColumnInfo(name = "title")         var title: String,
        @ColumnInfo(name = "note")          var note: String
    )