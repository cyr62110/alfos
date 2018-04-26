package fr.cvlaminck.alfos.common.bucket

import fr.cvlaminck.alfos.common.storage.StorageId

/**
 * Unique identifier of a [Bucket].
 *
 * A bucket is identified by its [name], it is unique across the [Storage].
 * On some provider, the name may be unique across the entire provider (ex. Google cloud storage).
 */
data class BucketId(
        /**
         * Name of the [Bucket].
         */
        val name: String,
        /**
         * Identifier of the [Storage] hosting the blob contained in the bucket.
         */
        val storageId: StorageId
)
