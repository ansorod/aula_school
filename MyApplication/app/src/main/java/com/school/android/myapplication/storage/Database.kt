package com.school.android.myapplication.storage

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(User::class), version = 1, exportSchema = true)
abstract class Database : RoomDatabase() {
    abstract fun userDao() : UserDao
}