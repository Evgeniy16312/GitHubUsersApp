package com.example.retrofitapplication.mvpusers

import com.example.retrofitapplication.data.repository.GitHubUser
import moxy.MvpView
import moxy.viewstate.strategy.alias.*


interface UsersView : MvpView {

    @AddToEnd
    fun showUsers(users: List<GitHubUser>)

    @AddToEndSingle
    fun setProgressBarVisibility(isVisible: Boolean)

    @AddToEndSingle
    fun showErrorVisibility(isVisibleError: Boolean)

}