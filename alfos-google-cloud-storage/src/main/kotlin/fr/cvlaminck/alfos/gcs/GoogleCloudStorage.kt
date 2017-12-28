package fr.cvlaminck.alfos.gcs

import com.google.cloud.storage.StorageOptions
import fr.cvlaminck.alfos.gcs.auth.GoogleCloudStorageCredentials
import fr.cvlaminck.alfos.gcs.operation.GoogleCloudStorageOperationsFactory
import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.model.StorageServiceProvider
import fr.cvlaminck.alfos.operation.StorageOperationsFactory

/**
 * Implementation of Storage allowing to access the Google Cloud storage associated to a Google Cloud project.
 *
 * @constructor
 * @param applicationName Name of this application.
 * @param projectId Id of the project to which is attached the Google cloud storage we will access using this storage.
 * @param credentials Credentials of an user having access to the project.
 */
class GoogleCloudStorage(
        val applicationName: String,
        val projectId: String,
        override val credentials: GoogleCloudStorageCredentials
) : Storage {

    val storage: com.google.cloud.storage.Storage = buildStorage()

    override val operationsFactory: StorageOperationsFactory = GoogleCloudStorageOperationsFactory(this)

    override val provider: StorageServiceProvider = GoogleCloudStorageProvider

    private fun buildStorage(): com.google.cloud.storage.Storage {
        TODO("Implements")
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is GoogleCloudStorage) return false

        if (projectId != other.projectId) return false

        return true
    }

    override fun hashCode(): Int {
        return projectId.hashCode()
    }
}
