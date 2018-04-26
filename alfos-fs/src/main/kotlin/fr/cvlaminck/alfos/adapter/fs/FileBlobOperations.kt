package fr.cvlaminck.alfos.adapter.fs

import fr.cvlaminck.alfos.adapter.operation.OperationOption
import fr.cvlaminck.alfos.adapter.operation.blob.BlobOperations
import fr.cvlaminck.alfos.common.blob.BlobId
import io.reactivex.Maybe
import io.reactivex.Single
import javafx.beans.property.Property
import java.io.InputStream
import java.io.OutputStream
import java.nio.file.Path

class FileBlobOperations (
        private val basePath: Path
) : BlobOperations {

    override fun getProperties(blobId: BlobId, options: Map<OperationOption<in Any>, Any>): Maybe<Map<Property<in Any>, Any>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun download(): Single<InputStream> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun upload(): Single<OutputStream> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
