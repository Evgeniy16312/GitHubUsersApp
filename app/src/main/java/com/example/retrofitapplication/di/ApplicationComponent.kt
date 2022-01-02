package com.example.retrofitapplication.di

import android.content.Context
import com.example.retrofitapplication.app.MainActivity
import com.example.retrofitapplication.mvpuser.di.GitHubUserComponent
import com.example.retrofitapplication.mvpusers.UsersPresenter
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

    fun provideGitHubUserComponent(): GitHubUserComponent.Builder

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setContext(context: Context): Builder
        fun build(): ApplicationComponent
    }


    fun inject(activity: MainActivity)
    fun inject(presenter: UsersPresenter)
}