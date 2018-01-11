package fr.cvlaminck.alfos.gcs.operation

import fr.cvlaminck.alfos.gcs.GoogleCloudTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("requires-gcs-account")
internal class GoogleCloudStorageObjectOperationsTest : GoogleCloudTest() {

    @Test
    fun getInformation() {
        val storageObject = storage.operationsFactory.getStorageObjectOperations("read-collection", "test")
                .getInformation()
                .blockingGet()

        assertSame(storage, storageObject.storage)
        assertEquals("read-collection", storageObject.collectionName)
        assertEquals("test", storageObject.name)
    }
}
