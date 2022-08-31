package io.github.rysefoxx.challenge.function.impl

import io.github.rysefoxx.challenge.extension.FunctionModule
import io.github.rysefoxx.document.impl.BackpackDocument
import io.github.rysefoxx.util.Utils
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

object BackpackFunction : FunctionModule() {

    override var id: String = "backpack"
    override var enabled: Boolean
        get() = BackpackDocument.get("enabled") as Boolean? ?: false
        set(value) = BackpackDocument.set("enabled", value)

    private var size: Int
        get() = BackpackDocument.get("size") as Int? ?: 27
        set(value) = BackpackDocument.set("size", value)

    private var inventory: Inventory? = null

    fun open(player: Player) {
        if (inventory == null) {
            inventory = Bukkit.createInventory(
                null,
                size,
                Utils.translateKey("backpack_inventory_title")
            )
        }

        player.openInventory(inventory!!)
    }

}