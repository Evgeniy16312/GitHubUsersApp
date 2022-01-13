package com.example.retrofitapplication.data.retrofit

import com.example.retrofitapplication.data.repository.GitHubUser
import com.example.retrofitapplication.data.userrepository.GHuserResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubApi {

    @GET("/users")
    fun fetchUsers(): Single<List<GitHubUser>>

    @GET("/users/{login}")
    fun fetchUserByLogin(@Path("login") login: String): Single<GitHubUser>

    @GET("/users/{login}/repos")
    fun fetchUserRepositories(@Path("login") login: String): Single<List<GHuserResponse>>
}