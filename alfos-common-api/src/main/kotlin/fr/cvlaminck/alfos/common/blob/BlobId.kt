package fr.cvlaminck.alfos.common.blob

import fr.cvlaminck.alfos.common.bucket.BucketId

/**
 * Unique identifier of a blob.
 *
 * The identifier precisely defined where the blob is stored and how it is named.
 */
data class BlobId (
        /**
         * Identifier of the bucket that contains the blob.
         */
        val bucketId: BucketId,
        /**
         * Name of the blob.
         */
        val name: String,
        /**
         * Version of the blob.
         *
         * It is only supported on some providers. If set for a provider not supporting
         * versioning, it will be ignored.
         */
        val version: String? = null
)
