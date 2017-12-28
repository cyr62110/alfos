package fr.cvlaminck.alfos.gcs.operation

import com.google.cloud.storage.Storage
import fr.cvlaminck.alfos.gcs.GoogleCloudStorage
import fr.cvlaminck.alfos.operation.StorageCollectionOperations
import fr.cvlaminck.alfos.operation.StorageObjectOperations
import fr.cvlaminck.alfos.operation.StorageOperations
import fr.cvlaminck.alfos.operation.StorageOperationsFactory

class GoogleCloudStorageOperationsFactory internal constructor(
        override val storage: GoogleCloudStorage,
        private val googleStorage: Storage
) : StorageOperationsFactory {

    override fun getStorageOperations(): StorageOperations {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getStorageCollectionOperations(collectionName: String): StorageCollectionOperations {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getStorageObjectOperations(collectionName: String, objectName: String): StorageObjectOperations {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
