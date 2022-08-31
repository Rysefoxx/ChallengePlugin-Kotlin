package io.github.rysefoxx.document

import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

abstract class AbstractDocument(name: String, path: String) {

    private var file: File? = null
    val config: YamlConfiguration

    init {
        file = File("plugins/ChallengePlugin/$path", "$name.yml")

        if (!file!!.exists()) {
            if (!file!!.parentFile.exists())
                file!!.parentFile.mkdirs()

            file!!.createNewFile()
        }

        config = YamlConfiguration.loadConfiguration(file!!)
        config.load(file!!)
    }

    fun saveDocument(): Exception? {
        try {
            config.save(file!!)
        } catch (e: Exception) {
            return e
        }

        return null
    }


    abstract fun load()

    abstract fun save()

    abstract fun saveDefault()

    abstract fun reload()

    abstract fun get(path: String): Any?

    abstract fun set(path: String, value: Any)
}