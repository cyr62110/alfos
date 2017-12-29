package fr.cvlaminck.alfos.model

import fr.cvlaminck.alfos.operation.StorageOperationsFactory

/**
 * Provide all the information to access to collections and objects on an account for a given provider.
 */
interface Storage {

    /**
     *
     */
    val operationsFactory: StorageOperationsFactory

    /**
     * Provider on which our objects are stored.
     */
    val provider: StorageServiceProvider
}
