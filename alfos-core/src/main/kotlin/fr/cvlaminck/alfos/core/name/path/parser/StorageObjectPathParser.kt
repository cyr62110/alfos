package fr.cvlaminck.alfos.core.name.path.parser

import fr.cvlaminck.alfos.core.name.path.StorageObjectPath
import fr.cvlaminck.alfos.core.name.path.builder.StorageObjectPathBuilder
import fr.cvlaminck.alfos.name.NameEncoder
import fr.cvlaminck.alfos.name.NameValidator

class StorageObjectPathParser(
        val nameValidator: NameValidator,
        val nameEncoder: NameEncoder,
        val pathSegmentSeparator: Char
) {

    fun parse(sPath: String): StorageObjectPath {
        val pathBuilder = StorageObjectPathBuilder(nameValidator, nameEncoder)

        var currentIndex = 0;
        var indexOfSeparator = -1;
        do {
            indexOfSeparator = sPath.indexOf(pathSegmentSeparator, currentIndex)
            if (indexOfSeparator == -1) {
                indexOfSeparator = sPath.length
            }
            pathBuilder.appendPathSegment(sPath.substring(currentIndex, indexOfSeparator))
            currentIndex = indexOfSeparator + 1
        } while (currentIndex < sPath.length)

        return pathBuilder.build()
    }
}
