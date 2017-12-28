package fr.cvlaminck.alfos.gcs.model

import com.google.cloud.storage.Bucket
import fr.cvlaminck.alfos.model.StorageCollection

internal class GoogleCloudStorageCollection(
        private val bucket: Bucket
) : StorageCollection {

    override val name: String = bucket.name
}
