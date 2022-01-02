package com.example.retrofitapplication.di

import com.example.retrofitapplication.mvpuser.di.GitHubUserComponent
import com.example.retrofitapplication.navigation.CustomRouter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [GitHubUserComponent::class])
class CiceroneModule {

    var cicerone: Cicerone<CustomRouter> = Cicerone.create(CustomRouter())

    @Provides
    fun cicerone(): Cicerone<CustomRouter> = cicerone

    @Singleton
    @Provides
    fun navigatorHolder(): NavigatorHolder = cicerone.getNavigatorHolder()

    @Singleton
    @Provides
    fun router(): CustomRouter = cicerone.router
}