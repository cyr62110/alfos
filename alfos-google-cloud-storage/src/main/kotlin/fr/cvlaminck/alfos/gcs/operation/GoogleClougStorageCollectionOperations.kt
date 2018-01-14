package fr.cvlaminck.alfos.gcs.operation

import com.google.cloud.storage.Bucket
import com.google.cloud.storage.Storage
import fr.cvlaminck.alfos.gcs.GoogleCloudStorage
import fr.cvlaminck.alfos.gcs.publisher.PagePublisher
import fr.cvlaminck.alfos.model.StorageCollection
import fr.cvlaminck.alfos.model.StorageObject
import fr.cvlaminck.alfos.operation.raw.RawStorageCollectionOperations
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

internal class GoogleClougStorageCollectionOperations(
        val collectionName: String,
        val storage: GoogleCloudStorage,
        val googleStorage: Storage
) : RawStorageCollectionOperations {

    override fun getInformation(): Maybe<StorageCollection>
            = Maybe.fromCallable(::getBucket)
            .map(storage.collectionMapper::map)

    private fun getBucket(): Bucket? = googleStorage
            .get(collectionName, Storage.BucketGetOption.fields(*Storage.BucketField.values())) // FIXME filter only field that are usefull

    override fun listObjects(): Flowable<StorageObject>
            = Flowable.fromPublisher(PagePublisher { googleStorage.list(collectionName) }) // FIXME list options
            .map(storage.objectMapper::map)
}
