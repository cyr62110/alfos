package fr.cvlaminck.alfos.core.name.path

import fr.cvlaminck.alfos.core.name.path.builder.StorageObjectPathBuilder
import fr.cvlaminck.alfos.name.NameEncoder
import fr.cvlaminck.alfos.name.NameValidator

/**
 * Representation of the name of the object as a virtual hierarchy in a collection.
 *
 * All the path are absolute but they not start with a path separator.
 * The root directory contains all object having a name without segment separator. All the object having the same
 * leading path segments will be considered as grouped.
 *
 * Examples:
 * - test.txt -> 'test.txt' in the root directory
 * - A/test.txt -> 'test.txt' in 'A' directory at the root.
 * - A/B/test.txt -> 'test.txt' in 'A' directory in 'B' directory at the root.
 */
open class StorageObjectPath internal constructor(
        val nameValidator: NameValidator,
        val nameEncoder: NameEncoder,
        val segments: List<String>
) {

    fun buildUpon(): StorageObjectPathBuilder = StorageObjectPathBuilder(nameValidator, nameEncoder, segments)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StorageObjectPath) return false

        if (segments != other.segments) return false

        return true
    }

    override fun hashCode(): Int = segments.hashCode()
}
