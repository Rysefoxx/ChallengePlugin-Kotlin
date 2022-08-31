package io.github.rysefoxx

import io.github.rysefoxx.challenge.function.FunctionManager
import io.github.rysefoxx.command.BackpackCommand
import io.github.rysefoxx.document.DocumentManager
import io.github.rysefoxx.language.Language
import net.axay.kspigot.main.KSpigot
import net.kyori.adventure.text.minimessage.MiniMessage

class ChallengePlugin : KSpigot() {

    companion object {
        val language = Language()
        val documentManager = DocumentManager()
        val miniMessage = MiniMessage.miniMessage()
    }

    override fun startup() {
        registerCommands()

        FunctionManager.registerAll()

        language.registerTranslations()
        documentManager.registerAll()
    }

    private fun registerCommands() {
        getCommand("backpack")!!.setExecutor(BackpackCommand())
    }
}