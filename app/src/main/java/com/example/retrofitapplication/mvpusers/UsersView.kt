package com.example.retrofitapplication.mvpusers

import com.example.retrofitapplication.data.repository.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState


interface UsersView : MvpView {

    @SingleState
    fun showUsers(users: List<GitHubUser>)

}