package dhbw.app_ent.demo.notes_room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dhbw.app_ent.demo.notes_room.models.Note
import androidx.room.Room
import android.content.Context

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao?

    companion object {
        // region implementation of singleton
        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context?): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context!!.applicationContext,
                                                AppDatabase::class.java,
                                          "database-name")
                        .build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
        // endregion
    }
}