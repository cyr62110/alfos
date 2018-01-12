package fr.cvlaminck.alfos.operation.raw

import fr.cvlaminck.alfos.model.StorageCollection
import io.reactivex.Flowable

/**
 * Provide all operations that can be executed on a storage.
 *
 * This class describe the contract between the core and a module associated to a provider.
 * It is strictly reserved for INTERNAL USE.
 *
 * @see fr.cvlaminck.alfos.operation.StorageOperations
 */
interface RawStorageOperations {

    /**
     * List the collections contained in the storage.
     *
     * @return a [Flowable] emitting the collections in the storage.
     */
    fun listCollections(): Flowable<StorageCollection>
}
