package fr.cvlaminck.alfos.common.storage

/**
 * Define the required information to access a given storage on a provider.
 *
 * On most provider, the [StorageAccess] will contains the credentials to access
 * the storage as well as the identifier of the storage.
 *
 * ex: For Google cloud storage, the information required are the project id and some
 * GoogleCredentials that have access to the project.
 */
interface StorageAccess {
}
