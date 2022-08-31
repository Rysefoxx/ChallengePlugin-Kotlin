package io.github.rysefoxx.util

import io.github.rysefoxx.ChallengePlugin
import net.axay.kspigot.extensions.bukkit.render
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer
import java.util.*

object Utils {

    private fun translateMessage(message: String): Component {
        return ChallengePlugin.miniMessage.deserialize(message)
    }

    fun translateKey(key: String): Component {
        return translateMessage(PlainTextComponentSerializer.plainText().serialize(Component.translatable(key)))
    }

    fun translateKey(key: String, locale: Locale): Component {
        return translateMessage(
            PlainTextComponentSerializer.plainText().serialize(Component.translatable(key).render(locale))
        )
    }

}