package dhbw.androidmate.anujgupta.notes_room.database

import kotlin.Throws
import dhbw.androidmate.anujgupta.notes_room.ui.main.MainViewInterface
import dhbw.androidmate.anujgupta.notes_room.R
import dhbw.androidmate.anujgupta.notes_room.ui.add_note.AddNoteActivity
import dhbw.androidmate.anujgupta.notes_room.adapters.NotesAdapter
import dhbw.androidmate.anujgupta.notes_room.ui.add_note.AddNoteViewInterface
import dhbw.androidmate.anujgupta.notes_room.ui.main.MainActivity
import dhbw.androidmate.anujgupta.notes_room.adapters.NotesAdapter.NotesViewHolder
import dhbw.androidmate.anujgupta.notes_room.database.NoteDao
import dhbw.androidmate.anujgupta.notes_room.database.AppDatabase
import dhbw.androidmate.anujgupta.notes_room.models.Note
import android.content.Context
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.disposables.Disposable
import dhbw.androidmate.anujgupta.notes_room.database.LocalCacheManager
import io.reactivex.functions.Consumer
import java.lang.Exception

class LocalCacheManager(private val context: Context?) {
    private val db: AppDatabase?

    fun getNotes(mainViewInterface: MainViewInterface?) {
        db?.noteDao()?.getAll()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())?.subscribe(object : Consumer<MutableList<Note?>?> {
            @Throws(Exception::class)
            override fun accept(t: MutableList<Note?>) {
                mainViewInterface?.onNotesLoaded(t)
            }
        })
    }

    fun addNotes(addNoteViewInterface: AddNoteViewInterface?, title: String?, note_text: String?) {
        Completable.fromAction {
            val note = Note(title, note_text)
            db?.noteDao()?.insertAll(note)
        }.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(object : CompletableObserver {
                    override fun onSubscribe(d: Disposable?) {}
                    override fun onComplete() {
                        addNoteViewInterface?.onNoteAdded()
                    }

                    override fun onError(e: Throwable?) {
                        addNoteViewInterface?.onDataNotAvailable()
                    }
                })
    }

    companion object {
        private var _instance: LocalCacheManager? = null
        fun getInstance(context: Context?): LocalCacheManager? {
            if (_instance == null) {
                _instance = LocalCacheManager(context)
            }
            return _instance
        }
    }

    init {
        db = AppDatabase.Companion.getAppDatabase(context)
    }
}