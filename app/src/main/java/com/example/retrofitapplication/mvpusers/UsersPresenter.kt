package com.example.retrofitapplication.mvpusers

import com.example.retrofitapplication.data.GitHubUserRepository
import com.example.retrofitapplication.mvpuser.UserScreen
import com.example.retrofitapplication.navigation.CustomRouter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter


class UsersPresenter(
    private val userRepository: GitHubUserRepository,
    private val router: CustomRouter
) : MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        updateContent()
    }

    fun goToNextScreen(login: String) {
        router.navigateTo(UserScreen(login))
    }

    private fun updateContent() {
        userRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showUsers(it)
            }, {
                val errorMessage = it.message
                //DisplayError
            })
    }
}