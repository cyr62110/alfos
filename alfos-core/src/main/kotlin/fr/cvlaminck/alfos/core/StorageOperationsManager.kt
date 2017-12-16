package fr.cvlaminck.alfos.core

import fr.cvlaminck.alfos.core.name.path.StorageObjectUri
import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.operation.StorageCollectionOperations
import fr.cvlaminck.alfos.operation.StorageObjectOperations
import fr.cvlaminck.alfos.operation.StorageOperations
import io.reactivex.Single

class StorageOperationsManager(
        private val registry: StorageRegistry,
        private val objectNameFactory: StorageObjectNameFactory,
        private val uriFactory: StorageObjectUriFactory
) {
    fun getStorageOperations(storage: Storage): Single<StorageOperations> {
        TODO("Implements")
    }

    fun getCollectionOperations(uri: StorageObjectUri): Single<StorageCollectionOperations> {
        TODO("Implements")
    }

    fun getCollectionOperations(uri: String): Single<StorageCollectionOperations> {
        TODO("Implements")
    }

    fun getObjectOperations(uri: StorageObjectUri): Single<StorageObjectOperations> {
        TODO("Implements")
    }

    fun getObjectOperations(uri: String): Single<StorageObjectOperations> {
        TODO("Implements")
    }
}
