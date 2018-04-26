package fr.cvlaminck.alfos.api.storage

import fr.cvlaminck.alfos.api.bucket.Bucket
import fr.cvlaminck.alfos.common.bucket.BucketId
import fr.cvlaminck.alfos.common.storage.StorageId
import io.reactivex.Flowable

/**
 * A storage is a collection of buckets.
 */
interface Storage {
    /**
     * Unique identifier of the storage.
     */
    val storageId: StorageId

    /**
     * List all buckets inside the storage.
     */
    fun listBuckets(options: ListBucketsOptions = ListBucketsOptions()): Flowable<Bucket>
}
