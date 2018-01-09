package fr.cvlaminck.alfos.operation

import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.model.StorageCollection
import fr.cvlaminck.alfos.model.StorageObject
import fr.cvlaminck.alfos.operation.raw.RawStorageCollectionOperations
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Provide all operations that can be executed on a collection.
 */
class StorageCollectionOperations internal constructor(
        /**
         * [Storage] containing the collection on which operations will be executed.
         */
        val storage: Storage,
        /**
         * Name of the collection on which operations will be executed.
         */
        val collectionName: String,
        private val rawStorageCollectionOperations: RawStorageCollectionOperations
) {

    /**
     * Get information(acl, ...) about the collection.
     * @return a [Single] emitting the information(acl, ...) about the collection.
     */
    fun getInformation(): Single<StorageCollection> = rawStorageCollectionOperations.getInformation()

    /**
     * List all objects in the collection.
     * @return a [Flowable] emitting all objects contained in the collection.
     */
    fun listObjects(): Flowable<StorageObject> = rawStorageCollectionOperations.listObjects()
}
