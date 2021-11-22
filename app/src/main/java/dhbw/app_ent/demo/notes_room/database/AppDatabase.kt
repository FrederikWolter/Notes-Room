package dhbw.app_ent.demo.notes_room.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import dhbw.app_ent.demo.notes_room.models.Note
import android.arch.persistence.room.Room
import android.content.Context

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao?

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getAppDatabase(context: Context?): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context!!.getApplicationContext(), AppDatabase::class.java, "database-name")
                        .build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}