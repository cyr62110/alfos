package fr.cvlaminck.alfos.operation.raw

import fr.cvlaminck.alfos.model.StorageObject
import io.reactivex.Single
import java.io.InputStream
import java.io.OutputStream

/**
 * Provide all operations that can be executed on an object.
 *
 * This class describe the contract between the core and a module associated to a provider.
 * It is strictly reserved for INTERNAL USE.
 *
 * @see fr.cvlaminck.alfos.operation.StorageObjectOperations
 */
interface RawStorageObjectOperations {

    /**
     * Get information(acl, ...) about the object.
     * @return a [Single] emitting the information(acl, ...) about the object.
     */
    fun getInformation(): Single<StorageObject>

    /**
     * Check whether the object exists in the storage.
     * @return a [Single] emitting true if an object with this name exists, false otherwise.
     */
    fun exists(): Single<Boolean>

    /**
     * Download the content of the object.
     * @return a [Single] emitting an [InputStream] allowing to download the content of the object.
     */
    fun download(): Single<InputStream>

    /**
     * Upload a content for the object.
     * @return a [Single] emitting an [OutputStream] allowing to upload the content of the object.
     */
    fun upload(): Single<OutputStream>
}
