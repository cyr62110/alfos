package fr.cvlaminck.alfos.model

import fr.cvlaminck.alfos.operation.raw.RawStorageOperationsFactory

/**
 * Provide all the information to access to collections and objects on an account for a given provider.
 */
interface Storage {

    /**
     * Name of this [Storage].
     */
    val name: String

    /**
     * Factory class that constructs classes providing operations on storage, collections and objects.
     */
    val operationsFactory: RawStorageOperationsFactory

    /**
     * Provider on which our objects are stored.
     */
    val provider: StorageServiceProvider
}
