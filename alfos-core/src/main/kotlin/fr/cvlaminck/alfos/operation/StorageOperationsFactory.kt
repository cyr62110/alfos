package fr.cvlaminck.alfos.operation

import fr.cvlaminck.alfos.model.Storage

/**
 * Factory class providing implementations of all operations that can executed on a given storage.
 */
interface StorageOperationsFactory {

    /**
     * Returns the storage on which operations will be executed.
     */
    val storage: Storage

    /**
     * Instantiate an implementation of [StorageOperations] that can operate on the [storage].
     *
     * @return a [StorageOperations] configured to work on the [storage].
     */
    fun getStorageOperations(): StorageOperations

    /**
     * Instantiate an implementation of [StorageCollectionOperations] that can operate on the provided collection.
     *
     * @param collectionName Name of the collection on which the operations will be executed.
     * @return a [StorageCollectionOperations] configured to work on the provided collection.
     */
    fun getStorageCollectionOperations(collectionName: String): StorageCollectionOperations

    /**
     * Instantiate an implementation of [StorageObjectOperations] that can operate on the provided object.
     *
     * @param collectionName Name of the collection containing the object in the [storage].
     * @param objectName Name of the object on which the operations will be executed.
     * @return a [StorageObjectOperations] configured to work on the provided object.
     */
    fun getStorageObjectOperations(collectionName: String, objectName: String): StorageObjectOperations
}
