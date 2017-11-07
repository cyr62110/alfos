package fr.cvlaminck.alfos.core.name.path.builder

import fr.cvlaminck.alfos.core.name.path.StorageObjectPath
import fr.cvlaminck.alfos.name.NameEncoder
import fr.cvlaminck.alfos.name.NameValidator

/**
 *
 * @param nameValidator
 * @param nameEncoder
 */
class StorageObjectPathBuilder (
        private val nameValidator: NameValidator,
        private val nameEncoder: NameEncoder
) {
    private val segments: MutableList<String> = arrayListOf()

    fun appendPathSegment(segment: String): StorageObjectPathBuilder {
        val encodedSegment = nameEncoder.encodePathSegmentInObjectName(segment)
        return appendEncodedPathSegment(encodedSegment)
    }

    fun appendEncodedPathSegment(segment: String): StorageObjectPathBuilder {
        nameValidator.validatePathSegmentInObjectName(segment)
        segments.add(segment)
        return this
    }

    fun build(): StorageObjectPath {
        TODO("Implements")
    }

    companion object {
        val PATH_SEPARATOR = "/"
    }
}
