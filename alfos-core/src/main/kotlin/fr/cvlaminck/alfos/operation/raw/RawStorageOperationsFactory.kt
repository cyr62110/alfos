package fr.cvlaminck.alfos.operation.raw

/**
 * Factory class providing implementations of all operations that can executed on a given storage.
 */
interface RawStorageOperationsFactory {

    /**
     * Instantiate an implementation of [RawStorageOperations] that can operate on the [storage].
     *
     * @return a [RawStorageOperations] configured to work on the [storage].
     */
    fun getStorageOperations(): RawStorageOperations

    /**
     * Instantiate an implementation of [RawStorageCollectionOperations] that can operate on the provided collection.
     *
     * @param collectionName Name of the collection on which the operations will be executed.
     * @return a [RawStorageCollectionOperations] configured to work on the provided collection.
     */
    fun getStorageCollectionOperations(collectionName: String): RawStorageCollectionOperations

    /**
     * Instantiate an implementation of [RawStorageObjectOperations] that can operate on the provided object.
     *
     * @param collectionName Name of the collection containing the object in the [storage].
     * @param objectName Name of the object on which the operations will be executed.
     * @return a [RawStorageObjectOperations] configured to work on the provided object.
     */
    fun getStorageObjectOperations(collectionName: String, objectName: String): RawStorageObjectOperations
}
