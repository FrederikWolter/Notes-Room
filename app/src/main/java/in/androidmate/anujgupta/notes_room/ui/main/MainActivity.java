package in.androidmate.anujgupta.notes_room.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.androidmate.anujgupta.notes_room.ui.add_note.AddNoteActivity;
import in.androidmate.anujgupta.notes_room.R;
import in.androidmate.anujgupta.notes_room.adapters.NotesAdapter;
import in.androidmate.anujgupta.notes_room.database.LocalCacheManager;
import in.androidmate.anujgupta.notes_room.models.Note;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    @BindView(R.id.rvNotes)
    RecyclerView rvNotes;

    RecyclerView.Adapter adapter;
    List<Note> notesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViews();
        loadNotes();

    }

    private void initViews() {

        rvNotes.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadNotes(){

        //Call Method to get Notes
        LocalCacheManager.getInstance(this).getUsers(this);


    }

    @OnClick(R.id.fabAddNote)
    public void addNote(){
        Intent i = new Intent(MainActivity.this,AddNoteActivity.class);
        startActivity(i);
    }

    @Override
    public void onNotesLoaded(List<Note> notes) {
        notesList = notes;

        if(notesList.size() == 0){
            onDataNotAvailable();
        }else {
            adapter = new NotesAdapter(this, notes);
            rvNotes.setAdapter(adapter);
        }
    }

    @Override
    public void onNoteAdded() {
        Toast.makeText(this,"Note Added",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataNotAvailable() {
        Toast.makeText(this,"No Notes Yet",Toast.LENGTH_SHORT).show();
    }
}

