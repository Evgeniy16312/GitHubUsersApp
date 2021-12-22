package com.example.retrofitapplication

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitapplication.mvpusers.UsersScreen
import com.example.retrofitapplication.navigation.CustomNavigator

class MainActivity : AppCompatActivity() {
    private val navigator = CustomNavigator(activity = this, R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            App.router.navigateTo(UsersScreen)
        }
    }

    override fun onPause() {
        App.navigatorHolder.removeNavigator()
        super.onPause()
    }
}