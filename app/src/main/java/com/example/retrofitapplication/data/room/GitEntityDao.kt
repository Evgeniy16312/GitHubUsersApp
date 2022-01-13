package com.example.retrofitapplication.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Single

@Dao
interface GitEntityDao {

    @Query("SELECT MAX(id) AS id FROM Entity")
    fun getQuantity(): Int

    @Query("SELECT * FROM Entity")
    fun getUsersList(): Single<List<Entity>>

    @Query("SELECT * FROM Entity WHERE login LIKE :login Limit 1")
    fun getUserByLogin(login: String): Single<Entity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(Entity: Entity)

    @Query("UPDATE Entity SET url = :url WHERE id = :id")
    fun update(id: Int, url: String)

}