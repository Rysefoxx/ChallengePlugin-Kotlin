package io.github.rysefoxx.language

import io.github.rysefoxx.challenge.function.FunctionManager
import net.axay.kspigot.extensions.broadcast
import net.axay.kspigot.extensions.bukkit.render
import net.axay.kspigot.runnables.taskRunLater
import net.kyori.adventure.key.Key
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TranslatableComponent
import net.kyori.adventure.translation.GlobalTranslator
import net.kyori.adventure.translation.TranslationRegistry
import java.util.*
import kotlin.collections.ArrayList

class Language {

    private val registry = TranslationRegistry.create(Key.key("io.github.rysefoxx")).apply {
        defaultLocale(Locale.GERMANY)
    }

    fun registerTranslations() {
        FunctionManager.functions.forEach {
            registry.registerAll(Locale.US, ResourceBundle.getBundle("language.function.english.${it.id}", Locale.US), false)
            registry.registerAll(Locale.GERMANY, ResourceBundle.getBundle("language.function.german.${it.id}", Locale.GERMANY), false)
        }

        GlobalTranslator.translator().addSource(registry)
    }

}