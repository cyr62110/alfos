package fr.cvlaminck.alfos.adapter.storage

import fr.cvlaminck.alfos.common.provider.StorageProvider
import fr.cvlaminck.alfos.common.storage.StorageAccess

/**
 * Defines all the operations a provider adapter must provides in order to be
 * operated using alfos library.
 */
interface StorageProviderAdapter : StorageProvider {

    /**
     * Unique identifier of the provider.
     */
    val providerId: String

    /**
     *
     */
    fun createStorageOperationProvider(storageAccess: StorageAccess?): StorageOperationsProvider
}
