package fr.cvlaminck.alfos.s3.operation

import fr.cvlaminck.alfos.s3.AmazonS3Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("requires-s3-account")
internal class AmazonS3StorageOperationsTest : AmazonS3Test() {

    @Test
    fun listBuckets() {
        val storageOperations = storage.operationsFactory.getStorageOperations()

        val collectionNames = storageOperations.listCollections()
                .map { it.name }
                .toList()
                .blockingGet()

        Assertions.assertEquals(
                listOf("read-collection"),
                collectionNames
        )
    }
}
