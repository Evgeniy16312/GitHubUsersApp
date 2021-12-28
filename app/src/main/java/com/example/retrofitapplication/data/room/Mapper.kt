package com.example.retrofitapplication.data.room

import com.example.retrofitapplication.data.repository.GitHubUser

fun convertEntityToGitHubUser(entity: Entity): GitHubUser {
    return GitHubUser(
        entity.id.toString(),
        entity.login,
        entity.avatarUrl,
        entity.url
    )
}
fun convertEntityListToGitHubUserList(entityList: List<Entity>): List<GitHubUser> {
    return entityList.map {
        GitHubUser(
            it.id.toString(),
            it.login,
            it.avatarUrl,
            it.url
        ) }
}
fun convertGitHubUserListToEntityList(gitUsersList: List<GitHubUser>): List<Entity> {
    return gitUsersList.map {
        Entity(
            0,
            it.id!!.toInt(),
            it.login!!,
            it.avatarUrl!!,
            it.url
        ) }
}
fun convertGitHubUserToEntity(gitHubUser: GitHubUser): Entity {
    return Entity(
        0,
        gitHubUser.id!!.toInt(),
        gitHubUser.login!!,
        gitHubUser.avatarUrl!!,
        gitHubUser.url
    )
}