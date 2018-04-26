package fr.cvlaminck.alfos.adapter.operation.storage

import fr.cvlaminck.alfos.adapter.operation.OperationOptions
import fr.cvlaminck.alfos.common.Property
import fr.cvlaminck.alfos.common.storage.StorageId
import io.reactivex.Flowable

/**
 * Provide all operations that can be executed on a storage.
 */
interface StorageOperations {

    /**
     * List the collections contained in the storage.
     *
     * Each bucket will be emitted as a [Map] of its properties.
     * The properties available on each bucket
     *
     * @param storageId Identifier of the [Storage] that is being listed.
     * @param options Options .
     *
     * @return a [Flowable] emitting the collections in the storage.
     */
    fun listBuckets(storageId: StorageId, options: OperationOptions): Flowable<Map<Property<out Any>, Any>>
}
