package com.school.android.myapplication.storage

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long, val name: String
)

