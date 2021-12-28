package com.example.retrofitapplication.di

import android.content.Context
import com.example.retrofitapplication.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        CiceroneModule::class,
        RepositoryModule::class,
        RoomModule::class
    ]
)

interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setContext(context: Context): Builder
        fun build(): ApplicationComponent
    }

    fun inject(activity: MainActivity)
    fun inject(activity: GitHubUsersPresenter)
    fun inject(activity: GitHubUserPresenter)
}