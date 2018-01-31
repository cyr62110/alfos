package fr.cvlaminck.alfos.s3.operation

import fr.cvlaminck.alfos.operation.raw.RawStorageCollectionOperations
import fr.cvlaminck.alfos.operation.raw.RawStorageObjectOperations
import fr.cvlaminck.alfos.operation.raw.RawStorageOperations
import fr.cvlaminck.alfos.operation.raw.RawStorageOperationsFactory
import fr.cvlaminck.alfos.s3.AmazonS3Storage

class AmazonS3StorageOperationsFactory(private val amazonS3Storage: AmazonS3Storage) : RawStorageOperationsFactory {

    override fun getStorageOperations(): RawStorageOperations =
            AmazonS3StorageOperations(amazonS3Storage)

    override fun getStorageCollectionOperations(collectionName: String): RawStorageCollectionOperations =
            AmazonS3StorageCollectionOperations(collectionName, amazonS3Storage)

    override fun getStorageObjectOperations(collectionName: String, objectName: String): RawStorageObjectOperations =
            AmazonS3StorageObjectOperations(collectionName, objectName, amazonS3Storage)
}
