package fr.cvlaminck.alfos.adapter.fs

import fr.cvlaminck.alfos.adapter.operation.bucket.BucketOperations
import fr.cvlaminck.alfos.common.Property
import fr.cvlaminck.alfos.adapter.bucket.BucketProperties
import io.reactivex.Flowable
import io.reactivex.Maybe
import java.nio.file.Path

internal class FileBucketOperations (
        private val basePath: Path
) : BucketOperations {

    override fun getProperties(): Maybe<Map<BucketProperties, Any>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun listObjects(): Flowable<Map<Property<in Any>, Any>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
