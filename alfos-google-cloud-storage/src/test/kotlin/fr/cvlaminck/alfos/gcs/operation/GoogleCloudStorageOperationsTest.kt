package fr.cvlaminck.alfos.gcs.operation

import com.google.auth.oauth2.GoogleCredentials
import fr.cvlaminck.alfos.gcs.GoogleCloudStorage
import fr.cvlaminck.alfos.gcs.GoogleCloudTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("requires-gcs-account")
internal class GoogleCloudStorageOperationsTest : GoogleCloudTest() {

    @Test
    fun listBuckets() {
        val storageOperations = storage.operationsFactory.getStorageOperations()

        val collectionNames = storageOperations.listCollections()
                .map { it.name }
                .toList().blockingGet()

        assertEquals(
                listOf("read-collection"),
                collectionNames
        )
    }
}
