package fr.cvlaminck.alfos.core

import fr.cvlaminck.alfos.core.name.path.StorageObjectUri
import fr.cvlaminck.alfos.exception.AlfosRuntimeException
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

    fun getStorageOperations(storage: Storage): Single<StorageOperations>
            = Single.fromCallable { storage.operationsFactory.getStorageOperations() }
            .map { StorageOperations(storage, it) }

    fun getCollectionOperations(storage: Storage, collectionName: String): Single<StorageCollectionOperations>
            = Single.fromCallable { storage.operationsFactory.getStorageCollectionOperations(collectionName) }
            .map { StorageCollectionOperations(storage, collectionName, it) }

    fun getCollectionOperations(uri: StorageObjectUri): Single<StorageCollectionOperations>
            = findPotentialStorageMatchingUri(uri)
            .flatMap { getCollectionOperations(it, uri.collectionName) }

    fun getCollectionOperations(uri: String): Single<StorageCollectionOperations>
            = Single.just(uri)
            .map { uriFactory.parse(it) }
            .flatMap { getCollectionOperations(it) }

    fun getObjectOperations(storage: Storage, collectionName: String, objectName: String): Single<StorageObjectOperations>
            = Single.fromCallable { storage.operationsFactory.getStorageObjectOperations(collectionName, objectName) }
            .map { StorageObjectOperations(storage, collectionName, objectName, it) }

    fun getObjectOperations(uri: StorageObjectUri): Single<StorageObjectOperations>
            = findPotentialStorageMatchingUri(uri)
            .flatMap { getObjectOperations(it, uri.collectionName, uri.objectPath.toString()) }

    fun getObjectOperations(uri: String): Single<StorageObjectOperations>
            = Single.just(uri)
            .map { uriFactory.parse(it) }
            .flatMap { getObjectOperations(it) }

    private fun findPotentialStorageMatchingUri(uri: StorageObjectUri): Single<Storage> {
        val storages = registry.findStoragesByProviderScheme(uri.providerScheme)
        return when (storages.size) {
            0 -> Single.never()
            1 -> Single.just(storages.get(0))
            else -> Single.error(AlfosRuntimeException("Unable to determine storage matching '${uri}'. It happens when you register two storage with the same provider."))
        }
    }
}
