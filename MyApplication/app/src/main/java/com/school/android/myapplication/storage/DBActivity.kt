package com.school.android.myapplication.storage

import android.arch.persistence.room.Room
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.school.android.myapplication.R
import kotlinx.android.synthetic.main.activity_db.*

class DBActivity : AppCompatActivity() {

    private var num = 0;
    private var database : Database? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db)

        database = Room.databaseBuilder(this, Database::class.java, "school_db")
            .allowMainThreadQueries().build()


        addUser.setOnClickListener(View.OnClickListener {
            database?.userDao()?.insert(User(0,"Name{$num}"))
            num++
            showUsers()
        })
    }

    private fun showUsers() {
        val users = database?.userDao()?.getUsers()
        Log.i(TAG, "UserDAO: " + users?.size)
        users?.forEach {
            val id = it.id
            val name = it.name
            Log.i(TAG, "User - id: $id - name: $name")
        }
    }

    override fun onResume() {
        super.onResume()
        preferences()
    }

    private fun preferences() {
        val preferences = getSharedPreferences("my_shared_preferences", Context.MODE_PRIVATE);
        val isFirstTime = preferences.getBoolean("first_time", false)

        Toast.makeText(this, "First Time? $isFirstTime", Toast.LENGTH_LONG).show()

        preferences.edit().putBoolean("first_time", true).apply()
    }

    companion object {
        const val TAG = "tag_storage"
    }
}
