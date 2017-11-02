package fr.cvlaminck.alfos.operation

import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.model.StorageCollection
import io.reactivex.Flowable

/**
 * Provide all operations that can be executed on a storage.
 */
interface StorageOperations {

    /**
     * Storage on which the operation will be executed
     */
    val storage: Storage

    /**
     * List all collections contained in the storage.
     */
    fun listCollections(): Flowable<StorageCollection>
}
