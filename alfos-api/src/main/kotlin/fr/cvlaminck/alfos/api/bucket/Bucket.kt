package fr.cvlaminck.alfos.api.bucket

import fr.cvlaminck.alfos.common.bucket.BucketId
import io.reactivex.Completable
import io.reactivex.Single

/**
 * A bucket is a collection of [Blob] stored in a [Storage].
 */
interface Bucket {

    /**
     * Unique identifier of the bucket.
     */
    val bucketId: BucketId

    fun getProperties(forceUpdate: Boolean): Single<BucketProperties>

    /**
     * Create the bucket
     */
    fun create(): Completable
}
