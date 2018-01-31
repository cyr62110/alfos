package fr.cvlaminck.alfos.s3.operation

import com.amazonaws.services.s3.model.ObjectListing
import com.amazonaws.services.s3.model.S3ObjectSummary
import fr.cvlaminck.alfos.model.StorageCollection
import fr.cvlaminck.alfos.model.StorageObject
import fr.cvlaminck.alfos.operation.raw.RawStorageCollectionOperations
import fr.cvlaminck.alfos.s3.AmazonS3Storage
import io.reactivex.Emitter
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.functions.BiFunction
import java.util.concurrent.Callable

class AmazonS3StorageCollectionOperations(
        private val collectionName: String,
        private val amazonS3Storage: AmazonS3Storage
) : RawStorageCollectionOperations {

    override fun getInformation(): Maybe<StorageCollection> =
            Single.fromCallable { amazonS3Storage.amazonS3.doesBucketExistV2(collectionName) }
                    .filter { it }
                    .map { StorageCollection(storage = amazonS3Storage, name = collectionName) }

    override fun listObjects(): Flowable<StorageObject> =
            Flowable.generate(Callable<ObjectListing> { amazonS3Storage.amazonS3.listObjects(collectionName) }, BiFunction<ObjectListing, Emitter<List<S3ObjectSummary>>, ObjectListing> { listing, emitter ->
                emitter.onNext(listing.objectSummaries)
                if (listing.isTruncated) {
                    return@BiFunction amazonS3Storage.amazonS3.listNextBatchOfObjects(listing)
                } else {
                    emitter.onComplete()
                    return@BiFunction listing
                }
            })
                    .flatMap { Flowable.fromIterable(it) }
                    .map { amazonS3Storage.objectMapper.map(it) }
}
