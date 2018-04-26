package fr.cvlaminck.alfos.api

import fr.cvlaminck.alfos.common.provider.StorageProvider
import fr.cvlaminck.alfos.common.storage.StorageAccess
import fr.cvlaminck.alfos.common.storage.StorageId
import io.reactivex.Single

/**
 * Register containing all the storage the library will operates on.
 *
 * The first step before starting using alfos library is to register all storages using [registerStorage] method.
 * Once the storage is registered, you can
 *
 * @since 1.0
 */
interface StorageRegistry {

    /**
     * Register a storage.
     *
     * @param storageProvider Provider that host the storage.
     * @param storageAccess Information required to identify and access the storage (ex. credentials).
     * @return the identifier of the storage that has been registered using the [storageAccess].
     * @since 1.0
     */
    fun registerStorage(storageProvider: StorageProvider, storageAccess: StorageAccess? = null): StorageId
}
