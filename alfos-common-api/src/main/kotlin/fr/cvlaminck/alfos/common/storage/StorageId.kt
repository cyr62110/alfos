package fr.cvlaminck.alfos.common.storage

/**
 * Unique identifier of a storage.
 *
 * The way to identify a storage depends highly on the provider. For ex, on Google cloud storage,
 * the storage is linked to the project and can be uniquely identified using a project id.
 */
interface StorageId {
    /**
     * Identifier of the provider which hosts the storage. (ex. Google Cloud storage, Amazon S3)
     */
    val providerId: String
}
