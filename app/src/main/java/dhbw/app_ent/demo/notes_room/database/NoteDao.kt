package dhbw.app_ent.demo.notes_room.database

import io.reactivex.Maybe
import dhbw.app_ent.demo.notes_room.models.Note
import androidx.room.*


@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    open fun getAll(): Maybe<MutableList<Note?>?>?
    @Insert
    open fun insertAll(vararg notes: Note?)
}