package fr.cvlaminck.alfos.core

import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.model.path.StorageObjectUri
import fr.cvlaminck.alfos.operation.StorageCollectionOperations
import fr.cvlaminck.alfos.operation.StorageObjectOperations
import fr.cvlaminck.alfos.operation.StorageOperations
import io.reactivex.Single

class StorageOperationsManager(
        val registry: StorageRegistry
) {
    fun getStorageOperations(storage: Storage): Single<StorageOperations> {
        TODO("Implements")
    }

    fun getCollectionOperations(uri: StorageObjectUri): Single<StorageCollectionOperations> {
        TODO("Implements")
    }

    fun getCollectionOperations(uri: String) = StorageObjectUri.fromString(uri)
            .flatMap { uri -> getCollectionOperations(uri) }

    fun getObjectOperations(uri: StorageObjectUri): Single<StorageObjectOperations> {
        TODO("Implements")
    }

    fun getObjectOperations(uri: String) = StorageObjectUri.fromString(uri)
            .flatMap { uri -> getObjectOperations(uri) }
}
