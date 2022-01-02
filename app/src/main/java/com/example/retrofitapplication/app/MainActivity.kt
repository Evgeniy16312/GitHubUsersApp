package com.example.retrofitapplication.app

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitapplication.mvpusers.UsersScreen
import com.example.retrofitapplication.navigation.CustomNavigator
import com.example.retrofitapplication.navigation.CustomRouter
import com.github.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val navigator = CustomNavigator(activity = this, R.id.content)

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: CustomRouter

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_item)
        App.instance.component.inject(this)
        if (savedInstanceState == null) {
            router.newRootScreen(UsersScreen)
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}