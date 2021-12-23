package com.example.retrofitapplication.mvpuser

import com.example.retrofitapplication.data.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState
import moxy.viewstate.strategy.alias.Skip


interface UserView : MvpView {

    @Skip
    fun toastError(text: String)

    @Skip
    fun showResult(user: GitHubUser)
}