package fr.cvlaminck.alfos.gcs.operation

import com.google.cloud.storage.Storage
import fr.cvlaminck.alfos.gcs.GoogleCloudStorage
import fr.cvlaminck.alfos.operation.raw.RawStorageCollectionOperations
import fr.cvlaminck.alfos.operation.raw.RawStorageObjectOperations
import fr.cvlaminck.alfos.operation.raw.RawStorageOperations
import fr.cvlaminck.alfos.operation.raw.RawStorageOperationsFactory

internal class GoogleCloudStorageOperationsFactory(
        val storage: GoogleCloudStorage,
        private val googleStorage: Storage
) : RawStorageOperationsFactory {

    override fun getStorageOperations(): RawStorageOperations
            = GoogleCloudStorageOperations(storage, googleStorage)

    override fun getStorageCollectionOperations(collectionName: String): RawStorageCollectionOperations
            = GoogleClougStorageCollectionOperations(collectionName, storage, googleStorage)

    override fun getStorageObjectOperations(collectionName: String, objectName: String): RawStorageObjectOperations {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
