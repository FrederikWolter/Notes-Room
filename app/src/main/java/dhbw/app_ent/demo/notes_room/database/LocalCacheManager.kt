package dhbw.app_ent.demo.notes_room.database

import android.content.Context
import dhbw.app_ent.demo.notes_room.models.Note
import dhbw.app_ent.demo.notes_room.ui.add_note.AddNoteViewInterface
import dhbw.app_ent.demo.notes_room.ui.main.MainViewInterface
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class LocalCacheManager(private val context: Context?) {
    private val db: AppDatabase? = AppDatabase.getAppDatabase(context)

    fun getNotes(mainViewInterface: MainViewInterface?) {
        db?.noteDao()?.getAll()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())?.subscribe { t ->
            mainViewInterface?.onNotesLoaded(t)
        }
    }

    fun addNotes(addNoteViewInterface: AddNoteViewInterface?, title: String, note_text: String) {
        Completable.fromAction {
            val note = Note(id=0, title = title, note = note_text)
            db?.noteDao()?.insertAll(note)
        }.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(object : CompletableObserver {
                    override fun onSubscribe(d: Disposable) {}
                    override fun onComplete() {
                        addNoteViewInterface?.onNoteAdded()
                    }

                    override fun onError(e: Throwable) {
                        addNoteViewInterface?.onDataNotAvailable()
                    }
                })
    }

    companion object {
        private var instance: LocalCacheManager? = null
        fun getInstance(context: Context?): LocalCacheManager? {
            if (instance == null) {
                instance = LocalCacheManager(context)
            }
            return instance
        }
    }

}