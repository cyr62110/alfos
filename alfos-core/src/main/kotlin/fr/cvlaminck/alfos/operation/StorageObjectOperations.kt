package fr.cvlaminck.alfos.operation

import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.model.StorageObject
import fr.cvlaminck.alfos.operation.raw.RawStorageObjectOperations
import io.reactivex.Maybe
import io.reactivex.Single
import java.io.InputStream
import java.io.OutputStream

/**
 * Provide all operations that can be executed on an object.
 */
class StorageObjectOperations(
        /**
         * [Storage] containing the object on which operations will be executed.
         */
        val storage: Storage,
        /**
         * Name of the collection that contains the object on which operations
         * will be executed.
         */
        val collectionName: String,
        /**
         * Name of the object on which operations will be executed.
         */
        val objectName: String,
        private val rawStorageObjectOperations: RawStorageObjectOperations
) {

    /**
     * Get information(acl, ...) about the object.
     *
     * If the object does not exists, nothing will be emitted in the returned [Maybe].
     *
     * @return a [Maybe] emitting the information(acl, ...) about the object, nothing if it does not exists.
     */
    fun getInformation(): Maybe<StorageObject> = rawStorageObjectOperations.getInformation()

    /**
     * Check whether the object exists in the storage.
     *
     * @return a [Single] emitting true if an object with this name exists, false otherwise.
     */
    fun exists(): Single<Boolean> = getInformation() // TODO when options are implemented, limit number of info get from the network to improve perf.
            .map { true }
            .toSingle(false)

    /**
     * Download the content of the object.
     *
     * @return a [Single] emitting an [InputStream] allowing to download the content of the object.
     */
    fun download(): Single<InputStream> = rawStorageObjectOperations.download()

    /**
     * Upload a content for the object.
     *
     * @return a [Single] emitting an [OutputStream] allowing to upload the content of the object.
     */
    fun upload(): Single<OutputStream> = rawStorageObjectOperations.upload()
}
