package fr.cvlaminck.alfos.s3.operation

import fr.cvlaminck.alfos.model.StorageObject
import fr.cvlaminck.alfos.operation.raw.RawStorageObjectOperations
import fr.cvlaminck.alfos.s3.AmazonS3Storage
import io.reactivex.Maybe
import io.reactivex.Single
import java.io.InputStream
import java.io.OutputStream
import java.io.PipedInputStream
import java.io.PipedOutputStream

class AmazonS3StorageObjectOperations(
        private val collectionName: String,
        private val objectName: String,
        private val amazonS3Storage: AmazonS3Storage
) : RawStorageObjectOperations {

    override fun getInformation(): Maybe<StorageObject> =
            Single.fromCallable { amazonS3Storage.amazonS3.doesObjectExist(collectionName, objectName) }
                    .filter { it }
                    .map { StorageObject(storage = amazonS3Storage, collectionName = collectionName, name = objectName) }

    override fun download(): Single<InputStream> =
            Single.fromCallable { amazonS3Storage.amazonS3.getObject(collectionName, objectName) }
                    .map { it.objectContent }

    override fun upload(): Single<OutputStream> =
            Single.fromCallable { PipedInputStream() }
                    .map {
                        amazonS3Storage.amazonS3.putObject(collectionName, objectName, it, TODO("must find a way to set metadata"))
                        PipedOutputStream(it)
                    }
}
