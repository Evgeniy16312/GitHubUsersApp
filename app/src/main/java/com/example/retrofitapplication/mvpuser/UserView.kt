package com.example.retrofitapplication.mvpuser

import com.example.retrofitapplication.data.repository.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.*


interface UserView : MvpView {

    @SingleState
    fun toastError(text: String)

    @SingleState
    fun showResult(user: GitHubUser)

    @AddToEndSingle
    fun setProgressBarVisibility(isVisible: Boolean)

    @AddToEndSingle
    fun showErrorVisibility(isVisibleError: Boolean)
}