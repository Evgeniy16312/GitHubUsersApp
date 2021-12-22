package com.example.retrofitapplication.navigation

import com.example.retrofitapplication.mvpuser.UserScreen
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward


class OpenDeepLink(private val deepLinkUserId: String) : CustomRouter.Command, Command {

    override fun execute(navigator: CustomNavigator) {
        navigator.applyCommand(Forward(UserScreen(deepLinkUserId)))
    }
}