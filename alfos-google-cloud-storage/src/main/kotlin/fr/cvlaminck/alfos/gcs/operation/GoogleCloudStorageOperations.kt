package fr.cvlaminck.alfos.gcs.operation

import com.google.cloud.storage.Storage
import fr.cvlaminck.alfos.gcs.GoogleCloudStorage
import fr.cvlaminck.alfos.gcs.model.GoogleCloudStorageCollection
import fr.cvlaminck.alfos.gcs.publisher.PagePublisher
import fr.cvlaminck.alfos.model.StorageCollection
import fr.cvlaminck.alfos.operation.StorageOperations
import io.reactivex.Flowable

class GoogleCloudStorageOperations internal constructor(
        override val storage: GoogleCloudStorage,
        private val googleStorage: Storage
) : StorageOperations {

    override fun listCollections(): Flowable<StorageCollection>
            = Flowable.fromPublisher(PagePublisher { googleStorage.list() })
            .map { GoogleCloudStorageCollection(it) }
}
