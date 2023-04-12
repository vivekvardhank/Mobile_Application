package com.example.myapplication.entities

import androidx.room.*

@Entity
data class Book(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "bookName") var bookName: String,
    @ColumnInfo(name = "bookAuthor") var bookAuthor: String
)

@Dao
interface BookDao{
    @Query("SELECT * FROM book")
    fun getAll(): List<Book>
}