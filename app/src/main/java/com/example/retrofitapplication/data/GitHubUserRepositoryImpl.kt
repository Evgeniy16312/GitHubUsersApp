package com.example.retrofitapplication.data

import com.example.retrofitapplication.data.room.RoomEngine
import com.example.retrofitapplication.data.room.convertEntityListToGitHubUserList
import com.example.retrofitapplication.data.room.convertEntityToGitHubUser
import com.example.retrofitapplication.data.room.convertGitHubUserToEntity
import io.reactivex.rxjava3.core.Single

class GitHubUserRepositoryImpl : GitHubUserRepository {

    private val gitHubApi = GitHubApiFactory.create()
    private val db = RoomEngine.create().getGitEntityDao()

    override fun getUsers(): Single<List<GitHubUser>> {
//        return gitHubApi.fetchUsers()
        return db.getUsersList()
            .flatMap {
                if (convertEntityListToGitHubUserList(it).isEmpty()) {
                    gitHubApi.fetchUsers().map { serverResult ->
                        for (item in serverResult) {
                            db.insert(convertGitHubUserToEntity(item))
                        }
                        serverResult
                    }
                } else {
                    Single.just(convertEntityListToGitHubUserList(it))
                }
            }
    }


    override fun getUserByLogin(userId: String): Single<GitHubUser> {
//        return gitHubApi.fetchUserByLogin(userId)
        return db.getUserByLogin(userId).flatMap {
            Single.just(convertEntityToGitHubUser(it))
        }
    }
}