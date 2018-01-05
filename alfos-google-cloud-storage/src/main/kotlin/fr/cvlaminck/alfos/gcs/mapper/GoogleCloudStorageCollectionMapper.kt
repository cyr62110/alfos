package fr.cvlaminck.alfos.gcs.mapper

import com.google.cloud.storage.Bucket
import fr.cvlaminck.alfos.gcs.GoogleCloudStorage
import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.model.StorageCollection

internal class GoogleCloudStorageCollectionMapper(
        private val storage: GoogleCloudStorage
) {

    fun map(bucket: Bucket): StorageCollection {
        return StorageCollection(
                storage,
                bucket.name
        )
    }
}
