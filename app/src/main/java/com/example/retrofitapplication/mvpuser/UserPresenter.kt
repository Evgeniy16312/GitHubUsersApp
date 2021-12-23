package com.example.retrofitapplication.mvpuser

import com.example.retrofitapplication.data.GitHubUser
import com.example.retrofitapplication.data.GitHubUserRepository
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.subjects.BehaviorSubject
import moxy.MvpPresenter


class UserPresenter(
    private val userId: Int,
    private val userRepository: GitHubUserRepository,
    private val subject: @NonNull BehaviorSubject<GitHubUser> = BehaviorSubject.create(),
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        setSubject()
        userRepository
            .getUsers()
            .subscribe({
                subject.onNext(it[userId - 1])
            }, {})
    }

    private fun setSubject() {
        subject
            .subscribe({
                viewState.showResult(it)
            }, {})
    }
}

