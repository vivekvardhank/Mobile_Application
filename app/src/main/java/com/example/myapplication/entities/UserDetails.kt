package com.example.myapplication.entities

import androidx.room.*

@Entity
data class UserDetails(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "userName") var userName: String,
    @ColumnInfo(name = "password") var password: String
)

@Dao
interface UserDetailsDao {
    @Query("SELECT * FROM userDetails")
    fun getAll(): List<UserDetails>

    @Query("SELECT EXISTS(SELECT * FROM userDetails WHERE userName = :userName)")
    fun isUserNamePresent(userName: String): Boolean

    @Query("SELECT EXISTS (SELECT * FROM userDetails WHERE userName = :userName AND password = :password)")
    fun isUserPresent(userName: String, password: String): Boolean

    @Insert
    fun insert(userDetails: UserDetails)

}