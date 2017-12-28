package fr.cvlaminck.alfos.gcs

import fr.cvlaminck.alfos.gcs.auth.GoogleStorageCredentials
import fr.cvlaminck.alfos.gcs.operation.GoogleStorageOperationsFactory
import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.model.StorageServiceProvider
import fr.cvlaminck.alfos.operation.StorageOperationsFactory

/**
 *
 *
 * @constructor
 * @param projectId Id of the project to which are attached the buckets we will access using this storage.
 * @param credentials Credentials of an user having access to the project.
 */
class GoogleStorage(
        val projectId: String,
        override val credentials: GoogleStorageCredentials
) : Storage {

    override val operationsFactory: StorageOperationsFactory = GoogleStorageOperationsFactory(this)

    override val provider: StorageServiceProvider = GoogleProvider

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GoogleStorage) return false

        if (projectId != other.projectId) return false

        return true
    }

    override fun hashCode(): Int {
        return projectId.hashCode()
    }
}
