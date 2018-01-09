package fr.cvlaminck.alfos.model

/**
 * Provide all information on an object stored in a collection on a storage.
 */
class StorageObject(
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
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StorageObject) return false

        // Hardcoded Storage equals to allow equals to work even if Storage equals has not been properly implemented
        // by third party.
        if (storage.name != other.storage.name) return false
        if (storage.provider.name != other.storage.provider.name) return false

        if (collectionName != other.collectionName) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = storage.hashCode()
        result = 31 * result + storage.provider.hashCode()
        result = 31 * result + collectionName.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

    @Suppress("RemoveCurlyBracesFromTemplate")
    override fun toString(): String {
        return "${name} <${collectionName}@${storage.name}> [${storage.provider.name}]"
    }
}
