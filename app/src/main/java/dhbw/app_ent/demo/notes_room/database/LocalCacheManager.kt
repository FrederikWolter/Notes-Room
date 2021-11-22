package dhbw.app_ent.demo.notes_room.database

import kotlin.Throws
import dhbw.app_ent.demo.notes_room.ui.main.MainViewInterface
import dhbw.app_ent.demo.notes_room.ui.add_note.AddNoteViewInterface
import dhbw.app_ent.demo.notes_room.models.Note
import android.content.Context
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import java.lang.Exception

class LocalCacheManager(private val context: Context?) {
    private val db: AppDatabase?

    fun getNotes(mainViewInterface: MainViewInterface?) {
        db?.noteDao()?.getAll()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())?.subscribe { t ->
            mainViewInterface?.onNotesLoaded(t)
        }
    }

    fun addNotes(addNoteViewInterface: AddNoteViewInterface?, title: String?, note_text: String?) {
        Completable.fromAction {
            val note = Note(title, note_text)
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

    init {
        db = AppDatabase.getAppDatabase(context)
    }
}