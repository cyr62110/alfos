package fr.cvlaminck.alfos.gcs.auth

import com.google.auth.Credentials
import com.google.auth.oauth2.GoogleCredentials
import fr.cvlaminck.alfos.gcs.GoogleCloudStorageProvider
import fr.cvlaminck.alfos.model.StorageServiceProvider
import fr.cvlaminck.alfos.model.auth.StorageCredentials

/**
 * Implementation of credentials that allow to authenticate to GCS.
 *
 * @constructor
 * @param credentials Google [Credentials] to use to authenticate to GCS.
 */
class GoogleCloudStorageCredentials(
        credentials: Credentials
) : StorageCredentials {

    override val provider: StorageServiceProvider = GoogleCloudStorageProvider

    companion object {
        val applicationDefault
            get() = GoogleCloudStorageCredentials(GoogleCredentials.getApplicationDefault())
    }
}
