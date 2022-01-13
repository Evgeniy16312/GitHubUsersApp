package com.example.retrofitapplication.mvpuser

import com.example.retrofitapplication.data.repository.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import moxy.viewstate.strategy.alias.Skip


interface UserView : MvpView {

    @SingleState
    fun toastError(text: String)

    @SingleState
    fun showResult(user: GitHubUser)

    @SingleState
    fun setProgressBarVisibility(isVisible: Boolean)
}