package com.karan.kisan_network.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.karan.kisan_network.model.Contact

@Database(
    entities = [
        Contact::class
    ], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "word_database"
                ).build()

                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
