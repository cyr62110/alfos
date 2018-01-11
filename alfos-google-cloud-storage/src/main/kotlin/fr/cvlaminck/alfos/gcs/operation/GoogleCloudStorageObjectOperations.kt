package fr.cvlaminck.alfos.gcs.operation

import com.google.cloud.storage.Storage
import fr.cvlaminck.alfos.gcs.GoogleCloudStorage
import fr.cvlaminck.alfos.model.StorageObject
import fr.cvlaminck.alfos.operation.raw.RawStorageObjectOperations
import io.reactivex.Single
import java.io.InputStream
import java.io.OutputStream

internal class GoogleCloudStorageObjectOperations(
        private val collectionName: String,
        private val objectName: String,
        private val storage: GoogleCloudStorage,
        private val googleStorage: Storage
) : RawStorageObjectOperations {

    override fun getInformation(): Single<StorageObject>
            = Single.fromCallable(::getBlob)
            .map(storage.objectMapper::map)

    private fun getBlob() = googleStorage.get(
            collectionName,
            objectName,
            Storage.BlobGetOption.fields(*Storage.BlobField.values()) // FIXME filter only field that are usefull
    )

    override fun exists(): Single<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun download(): Single<InputStream> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun upload(): Single<OutputStream> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}