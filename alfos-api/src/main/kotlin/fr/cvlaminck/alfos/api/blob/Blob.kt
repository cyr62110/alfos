package fr.cvlaminck.alfos.api.blob

import fr.cvlaminck.alfos.common.blob.BlobId
import io.reactivex.Single

/**
 * A blob represents a collection of raw bytes stored on a provider in a bucket.
 *
 * It can be used to store a file, a part of a file, etc. It does not have a defined
 * format. Metadata can be added on the blob to define its content, allow
 */
interface Blob {
    /**
     * Unique identifier.
     */
    val blobId: BlobId

    /**
     * Get the properties attached to this blob.
     *
     * @return [Single] emitting the properties attached to this blob.
     */
    fun getProperties(): Single<BlobProperties>

    /**
     * Update
     */

}
