package fr.cvlaminck.alfos.model

/**
 * Provide all information on an object stored in a collection on a storage.
 */
data class StorageObject(
        /**
         * Storage containing this object,
         */
        val storage: Storage,
        /**
         * Name of the collection containing this object.
         */
        val collectionName: String,
        /**
         * Name of the object.
         */
        val name: String
)
