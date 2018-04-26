package fr.cvlaminck.alfos.adapter.fs

import fr.cvlaminck.alfos.common.storage.StorageId
import java.nio.file.Path

internal class FileStorageId(
        override val providerId: String,
        val basePath: Path
) : StorageId {

    override fun toString(): String {
        return basePath.toString()
    }
}
