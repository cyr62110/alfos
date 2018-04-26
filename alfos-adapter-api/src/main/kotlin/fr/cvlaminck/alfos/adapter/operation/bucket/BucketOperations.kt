package fr.cvlaminck.alfos.adapter.operation.bucket

import fr.cvlaminck.alfos.common.Property
import fr.cvlaminck.alfos.adapter.bucket.BucketProperties
import io.reactivex.Flowable
import io.reactivex.Maybe

/**
 * Provide all operations that can be executed on a storage.
 */
interface BucketOperations {

    /**
     * Get properties about the bucket.
     *
     * The pro
     *
     * @return a [Maybe] emitting the information(acl, ...) about the collection, nothing if it does not exists.
     */
    fun getProperties(): Maybe<Map<BucketProperties, Any>>

    /**
     * List all objects in the collection.
     *
     * @return a [Flowable] emitting all objects contained in the collection.
     */
    fun listObjects(): Flowable<Map<Property<in Any>, Any>>
}
