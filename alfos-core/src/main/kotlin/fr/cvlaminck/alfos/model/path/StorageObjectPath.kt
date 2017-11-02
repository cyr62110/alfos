package fr.cvlaminck.alfos.model.path

/**
 * Representation of the name of the object as a virtual hierarchy in a collection.
 *
 * All the object having the same leading path segments will be considered as grouped.
 */
class StorageObjectPath(
        val segments: List<String>
) {
}
