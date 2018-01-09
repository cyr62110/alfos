package fr.cvlaminck.alfos.gcs.operation

import com.google.cloud.storage.Storage
import fr.cvlaminck.alfos.gcs.GoogleCloudStorage
import fr.cvlaminck.alfos.gcs.publisher.PagePublisher
import fr.cvlaminck.alfos.model.StorageCollection
import fr.cvlaminck.alfos.operation.StorageOperations
import fr.cvlaminck.alfos.operation.raw.RawStorageOperations
import io.reactivex.Flowable

internal class GoogleCloudStorageOperations(
        val storage: GoogleCloudStorage,
        private val googleStorage: Storage
) : RawStorageOperations {

    override fun listCollections(): Flowable<StorageCollection> // FIXME list options
            = Flowable.fromPublisher(PagePublisher { googleStorage.list() })
            .map { storage.collectionMapper.map(it) }
}
