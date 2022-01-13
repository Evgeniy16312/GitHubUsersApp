package com.example.retrofitapplication.di

import android.content.Context
import androidx.room.Room
import com.example.retrofitapplication.data.room.StorageDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Singleton
    @Provides
    fun providesRoomModule(app: Context): StorageDB {
        return Room.databaseBuilder(app, StorageDB::class.java, "github.db")
            .build()
    }
}