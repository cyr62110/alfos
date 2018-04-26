package fr.cvlaminck.alfos.adapter.fs

import fr.cvlaminck.alfos.adapter.storage.StorageOperationsProvider
import fr.cvlaminck.alfos.adapter.storage.StorageProviderAdapter
import fr.cvlaminck.alfos.common.storage.StorageAccess
import io.reactivex.Single
import java.nio.file.Path

class FileStorageProviderAdapter(
        private val basePath: Path,
        override val providerId: String = "file",
        override val scheme: String = "fs"
) : StorageProviderAdapter {

    private val storageId = FileStorageId(providerId, basePath)

    override fun createStorageOperationProvider(storageAccess: StorageAccess?)
            = StorageOperationsProvider(
            storageId,
            Single.just(FileStorageOperations(basePath)),
            Single.just(FileBucketOperations(basePath)),
            Single.just(FileBlobOperations(basePath)))
}
