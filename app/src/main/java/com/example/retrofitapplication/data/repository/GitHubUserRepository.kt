package com.example.retrofitapplication.data.repository


import com.example.retrofitapplication.data.repository.GitHubUser
import io.reactivex.rxjava3.core.Single

interface GitHubUserRepository {

    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(userId: String): Single<GitHubUser>

}