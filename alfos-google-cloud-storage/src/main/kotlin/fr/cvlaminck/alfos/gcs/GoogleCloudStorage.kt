package fr.cvlaminck.alfos.gcs

import com.google.auth.Credentials
import com.google.cloud.storage.StorageOptions
import fr.cvlaminck.alfos.gcs.mapper.GoogleCloudStorageCollectionMapper
import fr.cvlaminck.alfos.gcs.operation.GoogleCloudStorageOperationsFactory
import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.model.StorageServiceProvider
import fr.cvlaminck.alfos.operation.StorageOperationsFactory

/**
 * Implementation of Storage allowing to access the Google Cloud storage associated to a Google Cloud project.
 *
 * @constructor
 * @param projectId Id of the project to which is attached the Google cloud storage we will access using this storage.
 * @param credentials Google [Credentials] of an user having access to the project.
 */
class GoogleCloudStorage(
        val projectId: String,
        val credentials: Credentials
) : Storage {

    private val storageOptions: StorageOptions by lazy {
        StorageOptions.newBuilder()
                .setProjectId(projectId)
                .setCredentials(credentials)
                .build()
    }

    internal val collectionMapper: GoogleCloudStorageCollectionMapper = GoogleCloudStorageCollectionMapper(this)

    override val name: String = projectId

    override val operationsFactory: StorageOperationsFactory = GoogleCloudStorageOperationsFactory(this, storageOptions.service)

    override val provider: StorageServiceProvider = GoogleCloudStorageProvider

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
