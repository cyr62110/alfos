package fr.cvlaminck.alfos.s3.mapper

import com.amazonaws.services.s3.model.Bucket
import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.model.StorageCollection

class AmazonS3StorageCollectionMapper(
        private val storage: Storage
) {
    fun map(bucket: Bucket): StorageCollection =
            StorageCollection(storage = storage, name = bucket.name)
}
