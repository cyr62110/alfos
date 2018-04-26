package fr.cvlaminck.alfos.adapter.fs.mapper

import fr.cvlaminck.alfos.adapter.operation.OperationOptions
import fr.cvlaminck.alfos.common.Property
import fr.cvlaminck.alfos.adapter.bucket.BucketProperties
import java.nio.file.Path

internal class FileBucketPropertyMapper(
        private val options: OperationOptions
) {

    fun map(path: Path): Map<Property<out Any>, Any> {
        val result = mutableMapOf<Property<out Any>, Any>()
        result.put(BucketProperties.ID, path.fileName)
        return result
    }
}
