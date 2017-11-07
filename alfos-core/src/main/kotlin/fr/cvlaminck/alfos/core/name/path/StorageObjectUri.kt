package fr.cvlaminck.alfos.core.name.path

import io.reactivex.Single

class StorageObjectUri(
        val storageName : String,
        val storageCollectionName : String,
        val storageObjectPath: StorageObjectPath
) {

    companion object {
        fun fromString(uri: String): Single<StorageObjectUri> {
            TODO("Implements")
        }
    }
}
