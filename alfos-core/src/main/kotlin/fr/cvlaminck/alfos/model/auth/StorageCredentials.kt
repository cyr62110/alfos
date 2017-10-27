package fr.cvlaminck.alfos.model.auth

/**
 * Credentials to use to authenticate an account on a given provider.
 */
interface StorageCredentials {

    /**
     * Provider on which those credentials can be used.
     */
    val providerName: String
}