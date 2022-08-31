package io.github.rysefoxx.document

import io.github.rysefoxx.document.impl.BackpackDocument

class DocumentManager {

    private val documents = mutableListOf<AbstractDocument>()

    fun registerAll() {
        documents.add(BackpackDocument)
    }

}