package com.example.retrofitapplication.di

import com.example.retrofitapplication.data.repository.GitHubUserRepository
import com.example.retrofitapplication.data.repository.GitHubUserRepositoryImpl
import com.example.retrofitapplication.data.retrofit.GitHubApi
import com.example.retrofitapplication.data.room.StorageDB
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(api: GitHubApi, storageDB: StorageDB): GitHubUserRepository {
        return GitHubUserRepositoryImpl(api, storageDB)
    }
}