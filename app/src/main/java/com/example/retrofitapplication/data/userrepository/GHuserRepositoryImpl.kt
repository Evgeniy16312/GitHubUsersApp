package com.example.retrofitapplication.data.userrepository

import com.example.retrofitapplication.data.retrofit.GitHubApi
import com.example.retrofitapplication.data.room.userrepository.DBGitHubStorage
import com.example.retrofitapplication.data.room.userrepository.GitHubUserEntity
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GHuserRepositoryImpl
@Inject constructor(
    private val gitHubApi: GitHubApi,
    private val db: DBGitHubStorage
) : GHuserRepository {

    private val dbDao = db.getGitHubUserDao()

    override fun getUserByLogin(login: String) {

        gitHubApi.fetchUserRepositories(login)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe({
                for (item in it) {
                    item.name?.let { it1 ->
                        item.html_url?.let { it2 ->
                            GitHubUserEntity(0, login, item.id,
                                it1, it2
                            )
                        }
                    }?.let { it2 ->
                        dbDao.insert(
                            it2
                        )
                    }
                }
            }, {})
    }
}