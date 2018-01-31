package fr.cvlaminck.alfos.s3.operation

import fr.cvlaminck.alfos.model.StorageCollection
import fr.cvlaminck.alfos.operation.raw.RawStorageOperations
import fr.cvlaminck.alfos.s3.AmazonS3Storage
import io.reactivex.Flowable

class AmazonS3StorageOperations(private val storage: AmazonS3Storage) : RawStorageOperations {

    override fun listCollections(): Flowable<StorageCollection> =
            Flowable.fromIterable(storage.amazonS3.listBuckets())
                    .map(storage.collectionMapper::map)
}
