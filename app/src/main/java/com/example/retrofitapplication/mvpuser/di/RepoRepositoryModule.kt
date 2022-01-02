package com.example.retrofitapplication.mvpuser.di

import com.example.retrofitapplication.data.retrofit.GitHubApi
import com.example.retrofitapplication.data.room.userrepository.DBGitHubStorage
import com.example.retrofitapplication.data.userrepository.GHuserRepository
import com.example.retrofitapplication.data.userrepository.GHuserRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepoRepositoryModule {

    @FragmentScope
    @Provides
    fun provideRepository(api: GitHubApi, dbStorage: DBGitHubStorage): GHuserRepository {
        return GHuserRepositoryImpl(api, dbStorage)
    }
}