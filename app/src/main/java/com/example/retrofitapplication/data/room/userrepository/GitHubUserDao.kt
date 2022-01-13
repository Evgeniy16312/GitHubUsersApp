package com.example.retrofitapplication.data.room.userrepository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Single

@Dao
interface GitHubUserDao {

    @Query("SELECT * FROM GitHubUserEntity WHERE login LIKE :login Limit 1")
    fun getUserByLogin(login: String): Single<GitHubUserEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entity: GitHubUserEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertList(list: List<GitHubUserEntity>)

}