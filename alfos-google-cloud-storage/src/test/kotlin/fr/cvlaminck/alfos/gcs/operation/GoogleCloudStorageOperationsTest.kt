package fr.cvlaminck.alfos.gcs.operation

import com.google.auth.oauth2.GoogleCredentials
import fr.cvlaminck.alfos.gcs.GoogleCloudStorage
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("requires-gcs-account")
internal class GoogleCloudStorageOperationsTest {

    @Test
    fun listBuckets() {
        val credentials = GoogleCredentials.getApplicationDefault()
        val storage = GoogleCloudStorage("fftcg-deck-master", credentials)
        val storageOperations = storage.operationsFactory.getStorageOperations()

        val collections = storageOperations.listCollections().toList().blockingGet()
        System.out.println(collections)
    }
}
