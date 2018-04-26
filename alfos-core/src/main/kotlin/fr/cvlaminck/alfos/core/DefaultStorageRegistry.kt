package fr.cvlaminck.alfos.core

import fr.cvlaminck.alfos.adapter.storage.StorageOperationsProvider
import fr.cvlaminck.alfos.adapter.storage.StorageProviderAdapter
import fr.cvlaminck.alfos.api.StorageRegistry
import fr.cvlaminck.alfos.api.exception.MissingStorageException
import fr.cvlaminck.alfos.common.provider.StorageProvider
import fr.cvlaminck.alfos.common.storage.StorageAccess
import fr.cvlaminck.alfos.common.storage.StorageId
import io.reactivex.Single

/**
 * Default implementation of [StorageRegistry].
 *
 * The implementation is thread-safe,
 */
class DefaultStorageRegistry : StorageRegistry {

    private val operationProviders = mutableMapOf<StorageId, StorageOperationsProvider>()

    override fun registerStorage(storageProvider: StorageProvider, storageAccess: StorageAccess?): StorageId {
        if (!(storageProvider is StorageProviderAdapter)) {
            throw IllegalStateException("storageProvider must implements StorageProviderAdapter from adapter api.")
        }
        return synchronized(operationProviders) {
            val operationProvider = storageProvider.createStorageOperationProvider(storageAccess)
            operationProviders.put(operationProvider.storageId, operationProvider)
            operationProvider.storageId
        }
    }

    /**
     * FIXME
     *
     * @return a [Single] emitting a [StorageOperationsProvider] providing implementation of operations
     * for the given [storageId].
     */
    internal fun getStorageOperationsProvider(storageId: StorageId): Single<StorageOperationsProvider> = synchronized(operationProviders) {
        val operationProvider = operationProviders.get(storageId)
        if (operationProvider != null) {
            Single.just(operationProvider)
        } else {
            Single.error(MissingStorageException(storageId))
        }
    }
}
