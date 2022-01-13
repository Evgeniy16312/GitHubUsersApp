package com.example.retrofitapplication.mvpusers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.retrofitapplication.app.App
import com.example.retrofitapplication.R
import com.example.retrofitapplication.data.repository.GitHubUser
import com.example.retrofitapplication.databinding.ViewUsersBinding
import com.example.retrofitapplication.recycler.UsersAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UsersFragment : MvpAppCompatFragment(R.layout.view_users), UsersView,
    UsersAdapter.OnUserClickListener {

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter().apply {
            App.instance.component.inject(this)
        }
    }

    private val usersAdapter = UsersAdapter(this)
    private lateinit var viewBinging: ViewUsersBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinging = ViewUsersBinding.bind(view)
        viewBinging.usersRecycler.adapter = usersAdapter
    }

    override fun showUsers(users: List<GitHubUser>) {
        usersAdapter.submitList(users)
    }

    override fun setProgressBarVisibility(isVisible: Boolean) {
        val visibility = if (isVisible) {
            View.VISIBLE
        } else {
            View.GONE
        }
        viewBinging.progress.visibility = visibility
    }

    override fun showErrorVisibility(isVisibleError: Boolean) {
        val visibility = if (isVisibleError) View.VISIBLE else View.GONE
        viewBinging.networkError.visibility = visibility
    }

    override fun onUserPicked(user: GitHubUser) {
        presenter.goToNextScreen(user.login!!)
    }

    companion object {
        fun newInstance(): Fragment = UsersFragment()
    }
}