package com.example.retrofitapplication.data.userrepository

interface GHuserRepository {
    fun getUserByLogin(login: String)
}