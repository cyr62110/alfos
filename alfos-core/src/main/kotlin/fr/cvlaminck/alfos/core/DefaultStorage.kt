package fr.cvlaminck.alfos.core

import fr.cvlaminck.alfos.adapter.storage.StorageOperationsProvider
import fr.cvlaminck.alfos.api.bucket.Bucket
import fr.cvlaminck.alfos.api.storage.ListBucketsOptions
import fr.cvlaminck.alfos.api.storage.Storage
import fr.cvlaminck.alfos.common.storage.StorageId
import fr.cvlaminck.alfos.core.operation.option.storage.ListBucketOptionsMapper
import io.reactivex.Flowable
import io.reactivex.functions.BiFunction

class DefaultStorage(
        override val storageId: StorageId,
        private val storageOperationsProvider: StorageOperationsProvider
) : Storage {

    override fun listBuckets(options: ListBucketsOptions): Flowable<Bucket> {

        return storageOperationsProvider.storageOperations
                .zipWith(ListBucketOptionsMapper().map(options), BiFunction { t1, t2 ->
                    t1.listBuckets(storageId, t2)
                })
                .flatMap { it }

    }
}

