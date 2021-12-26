package com.example.retrofitapplication.data.room

import androidx.room.Room
import com.example.retrofitapplication.App


object RoomEngine {
    private val database: StorageDB by lazy {
        Room.databaseBuilder(App.ContextHolder.context, StorageDB::class.java, "github.db")
            .build()
    }

    fun create(): StorageDB = database
}