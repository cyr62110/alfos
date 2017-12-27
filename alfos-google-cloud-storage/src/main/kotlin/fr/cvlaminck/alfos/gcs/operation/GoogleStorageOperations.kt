package fr.cvlaminck.alfos.gcs.operation

import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.model.StorageCollection
import fr.cvlaminck.alfos.operation.StorageOperations
import io.reactivex.Flowable

class GoogleStorageOperations (
        override val storage: Storage
) : StorageOperations {

    override fun listCollections(): Flowable<StorageCollection> {

    }
}
