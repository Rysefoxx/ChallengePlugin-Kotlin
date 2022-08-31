package io.github.rysefoxx.command

import io.github.rysefoxx.challenge.function.impl.BackpackFunction
import io.github.rysefoxx.document.impl.BackpackDocument
import io.github.rysefoxx.util.Utils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class BackpackCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if(sender !is Player)
            return false

        when(BackpackDocument.get("enabled")) {
            false -> {
                sender.sendMessage(Utils.translateKey("backpack_command_disabled", sender.locale()))
                return false
            }
            true -> {
                BackpackFunction.open(sender)
            }
        }

        return true
    }

}