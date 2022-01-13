package com.example.retrofitapplication.mvpuser

import com.example.retrofitapplication.data.repository.GitHubUser
import com.example.retrofitapplication.data.repository.GitHubUserRepository
import com.example.retrofitapplication.data.userrepository.GHuserRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import moxy.MvpPresenter
import javax.inject.Inject


class UserPresenter(
    private val userId: String,
    private val subject: @NonNull BehaviorSubject<GitHubUser> = BehaviorSubject.create(),
) : MvpPresenter<UserView>() {

    @Inject
    lateinit var userRepository: GitHubUserRepository

    @Inject
    lateinit var ghUserRepository: GHuserRepository

    override fun onFirstViewAttach() {
        setSubject()
        userRepository
            .getUserByLogin(userId)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { viewState.setProgressBarVisibility(true) }
            .doOnSubscribe { viewState.showErrorVisibility(false) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.setProgressBarVisibility(false)
                subject.onNext(it)
            }, {
                viewState.setProgressBarVisibility(false)
                viewState.showErrorVisibility(true)
            })
    }

    private fun setSubject() {
        subject
            .subscribe({
                ghUserRepository.getUserByLogin(it.login!!)
                viewState.showResult(it)
            }, {})
    }
}
//    private fun setSubject() {
//        subject
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                viewState.showResult(it)
//            }, {})
//    }
