package com.example.retrofitapplication.mvpuser

import com.example.retrofitapplication.data.GitHubUserRepository
import com.example.retrofitapplication.navigation.CustomRouter
import moxy.MvpPresenter


class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository,
    private val router: CustomRouter
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        userRepository
            .getUserByLogin(userLogin)
            ?.let(viewState::showUser)
    }
}