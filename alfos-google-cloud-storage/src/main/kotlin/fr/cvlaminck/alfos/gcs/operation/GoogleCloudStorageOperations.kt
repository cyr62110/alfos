package fr.cvlaminck.alfos.gcs.operation

import com.google.cloud.storage.Storage
import fr.cvlaminck.alfos.gcs.GoogleCloudStorage
import fr.cvlaminck.alfos.model.StorageCollection
import fr.cvlaminck.alfos.operation.StorageOperations
import io.reactivex.Flowable

class GoogleCloudStorageOperations internal constructor(
        override val storage: GoogleCloudStorage,
        private val googleStorage: Storage
) : StorageOperations {

    override fun listCollections(): Flowable<StorageCollection> {
        TODO("Implements") // FIXME
    }
}
