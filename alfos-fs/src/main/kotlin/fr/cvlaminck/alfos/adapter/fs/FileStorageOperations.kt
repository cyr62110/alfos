package fr.cvlaminck.alfos.adapter.fs

import fr.cvlaminck.alfos.adapter.fs.mapper.FileBucketPropertyMapper
import fr.cvlaminck.alfos.adapter.operation.OperationOptions
import fr.cvlaminck.alfos.adapter.operation.storage.StorageOperations
import fr.cvlaminck.alfos.common.Property
import fr.cvlaminck.alfos.common.storage.StorageId
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Collectors

internal class FileStorageOperations(
        private val basePath: Path
) : StorageOperations {

    override fun listBuckets(storageId: StorageId, options: OperationOptions): Flowable<Map<Property<out Any>, Any>>
            = Observable.fromCallable { Files.list(basePath).collect(Collectors.toList()) }
            .flatMap { Observable.fromIterable(it) }
            .map { FileBucketPropertyMapper(options).map(it) }
            .toFlowable(BackpressureStrategy.BUFFER)
}
