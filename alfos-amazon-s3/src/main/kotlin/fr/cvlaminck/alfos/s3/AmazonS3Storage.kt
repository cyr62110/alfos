package fr.cvlaminck.alfos.s3

import com.amazonaws.services.s3.AmazonS3
import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.model.StorageServiceProvider
import fr.cvlaminck.alfos.operation.raw.RawStorageOperationsFactory
import fr.cvlaminck.alfos.s3.mapper.AmazonS3StorageCollectionMapper
import fr.cvlaminck.alfos.s3.mapper.AmazonS3StorageObjectMapper
import fr.cvlaminck.alfos.s3.operation.AmazonS3StorageOperationsFactory

class AmazonS3Storage(
        internal val amazonS3: AmazonS3
) : Storage {

    internal val collectionMapper = AmazonS3StorageCollectionMapper(this)

    internal val objectMapper = AmazonS3StorageObjectMapper(this)

    override val name: String
        get() = amazonS3.s3AccountOwner.displayName

    override val provider: StorageServiceProvider
        get() = AmazonS3StorageProvider

    override val operationsFactory: RawStorageOperationsFactory
        get() = AmazonS3StorageOperationsFactory(this)
}
