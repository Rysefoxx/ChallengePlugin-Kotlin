package io.github.rysefoxx.document.impl

import io.github.rysefoxx.document.AbstractDocument

object BackpackDocument : AbstractDocument("backpack", "functions") {

    private var size: Int = 9*3
    private var enabled: Boolean = false

    init {
        saveDefault()
    }

    override fun load() {
        size = config.getInt("size", 9 * 3)
        enabled = config.getBoolean("enabled", false)
    }

    override fun save() {
        config.set("size", size)
        config.set("enabled", enabled)

        val exception = saveDocument()
        if (exception != null)
            throw exception
    }

    override fun saveDefault() {
        config.addDefault("size", 9 * 3)
        config.addDefault("enabled", false)

        config.options().copyDefaults(true)
        val exception = saveDocument()

        if (exception != null)
            throw exception
    }

    override fun reload() {

    }

    override fun get(path: String): Any? {
        return config.get(path)
    }

    override fun set(path: String, value: Any) {
        config.set(path, value)
    }
}