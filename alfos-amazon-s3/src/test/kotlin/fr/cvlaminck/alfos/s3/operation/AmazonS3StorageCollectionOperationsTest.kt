package fr.cvlaminck.alfos.s3.operation

import fr.cvlaminck.alfos.s3.AmazonS3Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("requires-s3-account")
internal class AmazonS3StorageCollectionOperationsTest : AmazonS3Test() {

    @Test
    fun getInformation() {
        val storageCollection = storage.operationsFactory.getStorageCollectionOperations("read-collection")
                .getInformation()
                .blockingGet()

        assertSame(storage, storageCollection.storage)
        assertEquals("read-collection", storageCollection.name)
    }

    @Test
    fun getInformation_nonExisting() {
        val empty = storage.operationsFactory.getStorageCollectionOperations("non-existing-collection")
                .getInformation()
                .isEmpty
                .blockingGet()
        assertTrue(empty)
    }
}
