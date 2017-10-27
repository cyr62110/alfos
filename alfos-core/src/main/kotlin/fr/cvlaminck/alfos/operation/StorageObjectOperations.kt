package fr.cvlaminck.alfos.operation

import fr.cvlaminck.alfos.model.StorageObject

/**
 * Provide all operations that can be executed on an object.
 */
interface StorageObjectOperations {

    /**
     * Object on which operations will be executed.
     */
    val storageObject: StorageObject
}