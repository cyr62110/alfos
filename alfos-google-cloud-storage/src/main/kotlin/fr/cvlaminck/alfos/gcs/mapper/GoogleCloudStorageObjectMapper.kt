package fr.cvlaminck.alfos.gcs.mapper

import com.google.cloud.storage.Blob
import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.model.StorageObject

internal class GoogleCloudStorageObjectMapper(
        private val storage: Storage
){

    fun map(blob: Blob): StorageObject {
        return StorageObject(
                storage,
                blob.bucket,
                blob.name
        )
    }

    fun map(collectionName: String, objectName: String): BlobInfo {
        val info = BlobInfo.newBuilder(collectionName, objectName)
        return info.build()
    }
}
