package fr.cvlaminck.alfos.operation

import fr.cvlaminck.alfos.model.StorageObject
import fr.cvlaminck.alfos.model.StorageCollection
import io.reactivex.Flowable

/**
 * Provide all operations that can be executed on a storage.
 */
interface StorageCollectionOperations {

    /**
     * Collection on which operations will be executed.
     */
    val storageCollection: StorageCollection

    /**
     * List objects contained in the collection.
     */
    fun listObjects(): Flowable<StorageObject>
}