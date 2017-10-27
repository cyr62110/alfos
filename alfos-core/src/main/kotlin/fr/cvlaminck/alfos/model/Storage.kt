package fr.cvlaminck.alfos.model

import fr.cvlaminck.alfos.model.auth.StorageCredentials

/**
 * Provide all the information to access to collections and objects on an account for a given provider.
 */
interface Storage {

    /**
     * Credentials that must be used to authenticate your account on the provider.
     */
    var credentials: StorageCredentials

    /**
     * Name of the provider on which this storage is hosted. <br />
     * ex: GoogleCloudStorage, AmazonS3, Ceph, ...
     */
    val providerName: String
}