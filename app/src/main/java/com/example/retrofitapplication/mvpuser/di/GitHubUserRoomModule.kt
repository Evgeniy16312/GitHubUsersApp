package com.example.retrofitapplication.mvpuser.di

import android.content.Context
import androidx.room.Room
import com.example.retrofitapplication.data.room.userrepository.DBGitHubStorage
import dagger.Module
import dagger.Provides

@Module
class GitHubUserRoomModule {

    @FragmentScope
    @Provides
    fun providesRoom(app: Context): DBGitHubStorage {
        return Room.databaseBuilder(app, DBGitHubStorage::class.java, "newgithub.db")
            .build()
    }
}