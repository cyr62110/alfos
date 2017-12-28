package fr.cvlaminck.alfos.gcs.operation

import fr.cvlaminck.alfos.gcs.GoogleCloudStorage
import fr.cvlaminck.alfos.gcs.auth.GoogleCloudStorageCredentials
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("requires-gcs-account")
internal class GoogleCloudStorageOperationsTest {

    @Test
    fun listBuckets() {
        val credentials = GoogleCloudStorageCredentials.applicationDefault
        val storage = GoogleCloudStorage("test-project", credentials)
        val storageOperations = storage.operationsFactory.getStorageOperations()

        val collections = storageOperations.listCollections().toList().blockingGet()
        System.out.println(collections)
    }
}
