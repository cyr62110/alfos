package fr.cvlaminck.alfos.adapter.operation.blob

import fr.cvlaminck.alfos.adapter.operation.OperationOption
import fr.cvlaminck.alfos.common.blob.BlobId
import io.reactivex.Maybe
import io.reactivex.Single
import javafx.beans.property.Property
import java.io.InputStream
import java.io.OutputStream

/**
 * Provide all operations that can be executed on a blob.
 */
interface BlobOperations {

    /**
     * Get information(acl, ...) about the blob
     *
     * If the object does not exists, nothing will be emitted in the returned [Maybe].
     *
     * @return a [Maybe] emitting the properties(acl, ...) about the object, nothing if it does not exists.
     */
    fun getProperties(blobId: BlobId, options: Map<OperationOption<in Any>, Any>): Maybe<Map<Property<in Any>, Any>>

    /**
     * Download the content of the object.
     *
     * @return a [Single] emitting an [InputStream] allowing to download the content of the object.
     */
    fun download(): Single<InputStream>

    /**
     * Upload a content for the object.
     *
     * @return a [Single] emitting an [OutputStream] allowing to upload the content of the object.
     */
    fun upload(): Single<OutputStream>
}
