package fr.cvlaminck.alfos.gcs

import com.google.auth.Credentials
import com.google.auth.oauth2.GoogleCredentials

open class GoogleCloudTest {

    val credentials: Credentials by lazy {
        GoogleCredentials.getApplicationDefault() // FIXME: How to retrieve from env
    }

    val storage: GoogleCloudStorage by lazy {
        GoogleCloudStorage(
                "alfos-app", // FIXME: How to retrieve from env
                credentials
        )
    }
}
