package com.thoen.mechat.router

interface NameRouter {
    val route: String
}

object SignIn : NameRouter {
    override val route = "SignIn"
}

object SignUp : NameRouter {
    override val route = "SignUp"
}

object Chat : NameRouter {
    override val route = "Chat"
}

object Setting : NameRouter {
    override val route = "Setting"
}

object Navigation : NameRouter {
    override val route = "Navigation"
}

object ChatDetail : NameRouter {
    override val route = "ChatDetail"
}