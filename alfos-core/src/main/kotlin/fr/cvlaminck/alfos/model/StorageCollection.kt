package fr.cvlaminck.alfos.model

/**
 * Provide all information on a collection of objects stored in a storage.
 */
class StorageCollection(
        /**
         * [Storage] containing this collection.
         */
        val storage: Storage,
        /**
         * Name of the collection.
         */
        val name: String
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StorageCollection) return false

        // Hardcoded Storage equals to allow equals to work even if Storage equals has not been properly implemented
        // by third party.
        if (storage.name != other.storage.name) return false
        if (storage.provider.name != other.storage.provider.name) return false
        
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = storage.name.hashCode()
        result = 31 * result + storage.provider.name.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }
}
