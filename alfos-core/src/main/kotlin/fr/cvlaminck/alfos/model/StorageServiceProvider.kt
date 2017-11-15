package fr.cvlaminck.alfos.model

/**
 * Provide all information about an object-oriented storage service provider (ex: Google Cloud Storage).
 */
interface StorageServiceProvider {

    /**
     * Scheme used in uri to access storages of this provider.
     */
    val scheme: String

    /**
     * Name of this provider. <br />
     * ex: GoogleCloudStorage, AmazonS3, Ceph, ...
     */
    val providerName: String
}
