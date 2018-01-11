package fr.cvlaminck.alfos.gcs.operation

import fr.cvlaminck.alfos.gcs.GoogleCloudTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class GoogleClougStorageCollectionOperationsTest : GoogleCloudTest() {

    @Test
    fun getInformation() {
        val storageCollection = storage.operationsFactory.getStorageCollectionOperations("read-collection")
                .getInformation()
                .blockingGet()

        assertSame(storage, storageCollection.storage)
        assertEquals("read-collection", storageCollection.name)
    }
}
