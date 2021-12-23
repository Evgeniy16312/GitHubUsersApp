package com.example.retrofitapplication.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class GitHubUser(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("login")
    val login: String? = null,
    @SerializedName("avatar_url")
    val avatarUrl: String? = null,
    @SerializedName("url")
    val url: String = "",
) : Parcelable