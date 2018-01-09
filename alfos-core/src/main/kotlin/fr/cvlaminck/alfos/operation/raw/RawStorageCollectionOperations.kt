package fr.cvlaminck.alfos.operation.raw

import fr.cvlaminck.alfos.model.StorageCollection
import fr.cvlaminck.alfos.model.StorageObject
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Provide all operations that can be executed on a collection.
 *
 * This class describe the contract between the core and a module associated to a provider.
 * It is strictly reserved for INTERNAL USE.
 *
 * @see fr.cvlaminck.alfos.operation.StorageCollectionOperations
 */
interface RawStorageCollectionOperations {

    /**
     * Get information(acl, ...) about the collection.
     * @return a [Single] emitting the information(acl, ...) about the collection.
     */
    fun getInformation(): Single<StorageCollection>

    /**
     * List all objects in the collection.
     * @return a [Flowable] emitting all objects contained in the collection.
     */
    fun listObjects(): Flowable<StorageObject>
}
