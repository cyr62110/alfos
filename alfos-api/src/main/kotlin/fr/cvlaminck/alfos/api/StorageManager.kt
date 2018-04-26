package fr.cvlaminck.alfos.api

import fr.cvlaminck.alfos.api.bucket.Bucket
import fr.cvlaminck.alfos.api.storage.Storage
import fr.cvlaminck.alfos.common.blob.BlobId
import fr.cvlaminck.alfos.common.bucket.BucketId
import fr.cvlaminck.alfos.common.storage.StorageId
import io.reactivex.Single

/**
 * Component providing the object exposing the operations on blob, buckets and storage that
 * are available in the library.
 */
interface StorageManager {

    fun getStorage(storageId: StorageId): Single<Storage>

    fun getBucket(bucketId: BucketId): Single<Bucket>

    fun getBlob(blobId: BlobId): Single<BlobId>
}
