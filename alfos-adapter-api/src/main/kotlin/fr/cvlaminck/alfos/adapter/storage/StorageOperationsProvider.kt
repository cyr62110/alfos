package fr.cvlaminck.alfos.adapter.storage

import fr.cvlaminck.alfos.adapter.operation.blob.BlobOperations
import fr.cvlaminck.alfos.adapter.operation.bucket.BucketOperations
import fr.cvlaminck.alfos.adapter.operation.storage.StorageOperations
import fr.cvlaminck.alfos.common.storage.StorageId
import io.reactivex.Single

/**
 * Provides operation that can be executed on the storage with [storageId].
 *
 * All the operations class are provided as [Single], this allow the implementation of
 * the provider to instantiate thoses classes eagerly of lazily depending on the cost
 * of the instantiation.
 *
 * @since 1.0
 */
data class StorageOperationsProvider(
        /**
         * Identifier of the storage the operations can be executed on.
         *
         * @since 1.0
         */
        val storageId: StorageId,
        /**
         * Provides the operations on the storage.
         *
         * @since 1.0
         */
        val storageOperations: Single<StorageOperations>,
        /**
         * Provides the operations on buckets contained in the storage.
         *
         * @since 1.0
         */
        val bucketOperations: Single<BucketOperations>,
        /**
         * Provide the operations on objects contained in the storage.
         *
         * @since 1.0
         */
        val blobOperations: Single<BlobOperations>
)
