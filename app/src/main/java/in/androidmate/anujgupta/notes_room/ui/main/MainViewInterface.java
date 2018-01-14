package in.androidmate.anujgupta.notes_room.ui.main;

import java.util.List;

import in.androidmate.anujgupta.notes_room.models.Note;

/**
 * Created by anujgupta on 14/01/18.
 */

public interface MainViewInterface {

    void onNotesLoaded(List<Note> notes);

    void onNoteAdded();

    void onDataNotAvailable();

}
