package fr.cvlaminck.alfos.operation

import fr.cvlaminck.alfos.model.StorageCollection
import fr.cvlaminck.alfos.model.StorageObject
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Provide all operations that can be executed on a collection.
 */
interface StorageCollectionOperations {

    /**
     * Name of the collection on which operations will be executed.
     */
    val storageCollectionName: String

    /**
     * Get information(acl, ...) about the collection.
     * @return a {Single} emitting the information(acl, ...) about the collection.
     */
    fun getInformation(): Single<StorageCollection>

    /**
     * List all objects in the collection.
     * @return a {Flowable} emitting all objects contained in the collection.
     */
    fun listObjects(): Flowable<StorageObject>
}
