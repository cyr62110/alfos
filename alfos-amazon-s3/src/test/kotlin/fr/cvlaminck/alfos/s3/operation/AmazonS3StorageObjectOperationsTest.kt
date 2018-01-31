package fr.cvlaminck.alfos.s3.operation

import fr.cvlaminck.alfos.s3.AmazonS3Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("requires-s3-account")
internal class AmazonS3StorageObjectOperationsTest : AmazonS3Test() {

    @Test
    fun getInformation() {
        val storageObject = storage.operationsFactory.getStorageObjectOperations("read-collection", "test")
                .getInformation()
                .blockingGet()

        assertSame(storage, storageObject.storage)
        assertEquals("read-collection", storageObject.collectionName)
        assertEquals("test", storageObject.name)
    }

    @Test
    fun getInformation_notExisting() {
        val empty = storage.operationsFactory.getStorageObjectOperations("read-collection", "non-existing-object")
                .getInformation()
                .isEmpty
                .blockingGet()

        assertTrue(empty)
    }
}
