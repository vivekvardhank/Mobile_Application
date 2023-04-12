package com.example.myapplication.activities

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.entities.Book
import com.example.myapplication.entities.BookDao
import com.example.myapplication.entities.UserDetails
import com.example.myapplication.entities.UserDetailsDao

@Database(entities = [UserDetails::class,Book::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDetailsDao(): UserDetailsDao
    abstract fun bookDao(): BookDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}