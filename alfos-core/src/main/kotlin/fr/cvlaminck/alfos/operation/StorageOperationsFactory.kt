package fr.cvlaminck.alfos.operation

import fr.cvlaminck.alfos.model.Storage

/**
 * Factory class providing implementations of all operations that can executed on storages, collections and objects.
 */
interface StorageOperationsFactory {

    /**
     * Instantiate an implementation of [StorageOperations] that can operate on the provided [storage].
     *
     * @param storage [Storage] on which the operations will be executed.
     * @return a [StorageOperations] that can operate on the provided [storage].
     */
    fun getStorageOperations(storage: Storage): StorageOperations

    /**
     * Instantiate an implementation of [StorageCollectionOperations] that can operate on the provided collection.
     *
     * @param storage [Storage] containing the collection.
     * @param collectionName Name of the collection on which the operations will be executed.
     * @return a [StorageCollectionOperations] that can operate on the provided collection.
     */
    fun getStorageCollectionOperations(storage: Storage, collectionName: String): StorageCollectionOperations

    /**
     * Instantiate an implementation of [StorageObjectOperations] that can operate on the provided object.
     *
     * @param storage [Storage] containing the object.
     * @param collectionName Name of the collection containing the object in the [storage].
     * @param objectName Name of the object on which the operations will be executed.
     */
    fun getStorageObjectOperations(storage: Storage, collectionName: String, objectName: String): StorageObjectOperations
}
