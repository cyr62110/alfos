package fr.cvlaminck.alfos.core.name.path

import fr.cvlaminck.alfos.name.NameValidator

/**
 * Representation of the name of the object as a virtual hierarchy in a collection.
 *
 * All the object having the same leading path segments will be considered as grouped.
 */
class StorageObjectPath(
        val nameValidator: NameValidator,
        val segments: List<String>
) {
}
