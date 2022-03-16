package com.example.retrofitapplication

import com.example.retrofitapplication.data.repository.GitHubUser
import com.example.retrofitapplication.data.repository.GitHubUserRepository
import com.example.retrofitapplication.mvpusers.UsersPresenter
import com.example.retrofitapplication.mvpusers.UsersView
import io.reactivex.rxjava3.core.Single
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito


class MockitoTest {

//    @Mock
//    lateinit var usersView: UsersView
//
//    @Mock
//    lateinit var gitHubUserRepository: GitHubUserRepository
//
//
//    @Test
//    fun `display non-empty list`() {
//        val users = listOf(
//            GitHubUser("1", "first"),
//            GitHubUser("2", "second")
//        )
//
//
//        Mockito.`when`(gitHubUserRepository.getUsers()).thenReturn(Single.just(users))
//
//        val presenter = UsersPresenter(usersView, gitHubUserRepository)
//
//        presenter.start()
//
//        Mockito.verify(usersView).showUsers(users)
//    }
}