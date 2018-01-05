package fr.cvlaminck.alfos.model

import fr.cvlaminck.alfos.name.NameValidator

/**
 * Provide all information about an object-oriented storage service provider (ex: Google Cloud Storage).
 */
interface StorageServiceProvider {

    /**
     * Scheme used in uri to access storages of this provider.
     */
    val scheme: String

    /**
     * [NameValidator] to use to check that object/collection name are valid for this storage.
     */
    val nameValidator: NameValidator

    /**
     * Name of this provider. <br />
     * ex: GoogleCloudStorage, AmazonS3, Ceph, ...
     */
    val name: String
}
