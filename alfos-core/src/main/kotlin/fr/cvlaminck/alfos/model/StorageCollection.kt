package fr.cvlaminck.alfos.model

/**
 * Provide all information on a collection of objects stored in a storage.
 */
data class StorageCollection(
        /**
         * [Storage] containing this collection.
         */
        val storage: Storage,
        /**
         * Name of the collection.
         */
        val name: String
)
