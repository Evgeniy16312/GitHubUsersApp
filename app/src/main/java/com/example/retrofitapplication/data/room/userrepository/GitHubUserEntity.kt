package com.example.retrofitapplication.data.room.userrepository

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "GitHubUserEntity")
data class GitHubUserEntity(

    @PrimaryKey(autoGenerate = true)
    val localId: Int,
    val login: String,
    val id: String?,
    val name: String,
    val html_url: String
)