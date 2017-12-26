package fr.cvlaminck.alfos.core.name.path.parser

import fr.cvlaminck.alfos.core.name.path.StorageObjectPath
import fr.cvlaminck.alfos.core.name.path.builder.StorageObjectPathBuilder
import fr.cvlaminck.alfos.name.NameEncoder
import fr.cvlaminck.alfos.name.NameValidator

/**
 * Utility class providing method to parse raw string into [StorageObjectPath].
 * It will use a [NameValidator] and a [NameEncoder] to ensure the path is valid and can
 * be used as object name by providers.
 *
 * @constructor
 * @param nameValidator [NameValidator] used to validate if the parsed path is valid.
 * @param nameEncoder [NameEncoder] to use to encode path segment to ensure they are valid.
 */
internal class StorageObjectPathParser(
        private val nameValidator: NameValidator,
        private val nameEncoder: NameEncoder
) {

    /**
     * Parse a raw string into a [StorageObjectPath].
     * The path will be encoded by the [nameEncoder] and validated using the [nameValidator].
     *
     * @param sPath Raw string to parse.
     * @param startIndex Index of first character of the string to be considered part of the path.
     * @return a valid [StorageObjectPath].
     */
    fun parse(
            sPath: String,
            startIndex: Int = 0
    ): StorageObjectPath {
        val pathBuilder = StorageObjectPathBuilder(nameValidator, nameEncoder)

        var currentIndex = startIndex
        var indexOfSeparator = -1
        do {
            indexOfSeparator = sPath.indexOf(StorageObjectPath.PATH_SEPARATOR, currentIndex)
            if (indexOfSeparator == -1) {
                indexOfSeparator = sPath.length
            }
            pathBuilder.appendPathSegment(sPath.substring(currentIndex, indexOfSeparator))
            currentIndex = indexOfSeparator + 1
        } while (currentIndex < sPath.length)

        return pathBuilder.build()
    }
}
