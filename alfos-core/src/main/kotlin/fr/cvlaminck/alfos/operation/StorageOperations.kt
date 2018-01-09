package fr.cvlaminck.alfos.operation

import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.model.StorageCollection
import fr.cvlaminck.alfos.operation.raw.RawStorageOperations
import io.reactivex.Flowable

/**
 * Provide all operations that can be executed on a storage.
 */
class StorageOperations internal constructor(
        /**
         * [Storage] on which operations will be executed.
         */
        val storage: Storage,
        private val rawStorageOperations: RawStorageOperations
){

    /**
     * List the collections contained in [storage].
     *
     * @return a [Flowable] emitting the collections contained in [storage].
     */
    fun listCollections(): Flowable<StorageCollection> = rawStorageOperations.listCollections()
}
