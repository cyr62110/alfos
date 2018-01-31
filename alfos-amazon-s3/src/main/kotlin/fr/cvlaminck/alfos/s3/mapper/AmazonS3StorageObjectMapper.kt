package fr.cvlaminck.alfos.s3.mapper

import com.amazonaws.services.s3.model.S3ObjectSummary
import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.model.StorageObject

class AmazonS3StorageObjectMapper(
        private val storage: Storage
) {
    fun map(s3ObjectSummary: S3ObjectSummary): StorageObject =
            StorageObject(storage = storage, name = s3ObjectSummary.key, collectionName = s3ObjectSummary.bucketName)
}
