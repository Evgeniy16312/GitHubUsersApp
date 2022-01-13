package com.example.retrofitapplication.data.room


import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Entity::class], version = 1, exportSchema = false)
abstract class StorageDB : RoomDatabase() {

    abstract fun getGitEntityDao(): GitEntityDao

}
