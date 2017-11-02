package fr.cvlaminck.alfos.operation

interface StorageOperationsFactory {

    fun getStorageOperations(): StorageOperations

    fun getStorageCollectionOperations(): StorageCollectionOperations

    fun getStorageObjectOperations(): StorageObjectOperations
}
