package fr.cvlaminck.alfos.name.path.builder

import fr.cvlaminck.alfos.name.path.StorageObjectPath
import fr.cvlaminck.alfos.name.validator.NameValidator

class StorageObjectPathBuilder (
        private val nameValidator: NameValidator
) {

    private val segments: MutableList<String> = arrayListOf()

    fun appendPathSegment(segment: String): StorageObjectUriBuilder {
        TODO("Implements")
    }

    fun appendEncodedPathSegment(segment: String): StorageObjectPathBuilder {
        nameValidator.validatePathSegmentInObjectName(segment)
        return this
    }

    fun build(): StorageObjectPath {
        TODO("Implements")
    }

    companion object {
        val PATH_SEPARATOR = "/"
    }
}
