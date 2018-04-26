package fr.cvlaminck.alfos.core

import fr.cvlaminck.alfos.api.StorageManager
import fr.cvlaminck.alfos.api.bucket.Bucket
import fr.cvlaminck.alfos.api.storage.Storage
import fr.cvlaminck.alfos.common.blob.BlobId
import fr.cvlaminck.alfos.common.bucket.BucketId
import fr.cvlaminck.alfos.common.storage.StorageId
import io.reactivex.Single

class DefaultStorageManager(
        private val storageRegistry: DefaultStorageRegistry
) : StorageManager {

    override fun getStorage(storageId: StorageId): Single<Storage>
            = storageRegistry.getStorageOperationsProvider(storageId)
            .map { DefaultStorage(storageId, it) }

    override fun getBucket(bucketId: BucketId): Single<Bucket> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBlob(blobId: BlobId): Single<BlobId> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
