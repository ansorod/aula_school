package com.school.android.myapplication.storage

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    fun getUsers(): List<User>

    @Insert
    fun insert(vararg user: User)
}