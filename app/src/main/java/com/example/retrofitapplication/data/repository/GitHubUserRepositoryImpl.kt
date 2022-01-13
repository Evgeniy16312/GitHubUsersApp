package com.example.retrofitapplication.data.repository


import com.example.retrofitapplication.data.retrofit.GitHubApi
import com.example.retrofitapplication.data.room.*
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GitHubUserRepositoryImpl
@Inject constructor(
    private val gitHubApi: GitHubApi,
    private val db: StorageDB,
) : GitHubUserRepository {


    override fun getUsers(): Single<List<GitHubUser>> {
//        return gitHubApi.fetchUsers()
        return db.getGitEntityDao().getUsersList()
            .flatMap {
                if (convertEntityListToGitHubUserList(it).isEmpty()) {
                    gitHubApi.fetchUsers().map { serverResult ->
                        for (item in serverResult) {
                            db.getGitEntityDao().insert(convertGitHubUserToEntity(item))
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
        return db.getGitEntityDao().getUserByLogin(userId).flatMap {
            Single.just(convertEntityToGitHubUser(it))
        }
    }
}