package com.example.retrofitapplication.mvpuser

import com.example.retrofitapplication.data.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState


interface UserView : MvpView {

    @SingleState
    fun showUser(user: GitHubUser)

}