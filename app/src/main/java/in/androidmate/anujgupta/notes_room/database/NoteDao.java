package in.androidmate.anujgupta.notes_room.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import in.androidmate.anujgupta.notes_room.models.Note;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

/**
 * Created by anujgupta on 13/01/18.
 */

@Dao
public interface NoteDao {

    @Query("SELECT * FROM notes")
    Maybe<List<Note>> getAll();

    @Insert
    void insertAll(Note... notes);

}