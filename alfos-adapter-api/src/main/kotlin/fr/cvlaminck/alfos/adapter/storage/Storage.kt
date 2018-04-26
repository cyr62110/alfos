package fr.cvlaminck.alfos.adapter.storage

import fr.cvlaminck.alfos.common.storage.StorageId

/**
 *
 */
interface Storage {

    /**
     * Unique identifier of the storage.
     */
    val storageId: StorageId
}
