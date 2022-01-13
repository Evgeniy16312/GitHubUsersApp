package com.example.retrofitapplication.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Entity(

    @PrimaryKey(autoGenerate = true)
    val localId: Int,
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val url: String
)
