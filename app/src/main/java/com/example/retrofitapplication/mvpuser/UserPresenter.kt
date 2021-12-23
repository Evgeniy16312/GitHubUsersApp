package com.example.retrofitapplication.mvpuser

import com.example.retrofitapplication.data.GitHubUser
import com.example.retrofitapplication.data.GitHubUserRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.schedulers.Schedulers
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
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                subject.onNext(it[userId - 1])
            }, {})
    }

    private fun setSubject() {
        subject
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showResult(it)
            }, {})
    }
}