package io.github.rysefoxx.challenge.function

import io.github.rysefoxx.challenge.extension.FunctionModule
import io.github.rysefoxx.challenge.function.impl.BackpackFunction

object FunctionManager {

    val functions = mutableListOf<FunctionModule>()

    fun registerAll() {
        functions.add(BackpackFunction)
    }

}