package fr.cvlaminck.alfos.core.name.encoder

import fr.cvlaminck.alfos.name.NameEncoder
import fr.cvlaminck.alfos.util.range.CharacterRanges

/**
 * Implementation of [NameEncoder] that can be configured using [CharacterRanges] to determine which characters are
 * allowed in collection/object name. All other characters will be replaced by the [replacementChar].
 *
 * @param collectionNameAllowedRanges [CharacterRanges] containing all characters that are allowed in collection
 * name and will not be replaced by the [replacementChar].
 * @param pathSegmentInObjectNameAllowedRanges [CharacterRanges] containing all characters that are allowed in path
 * segment forming the object name and will not be replaced by the [replacementChar].
 * @param replacementChar Character that will be used to replace invalid characters.
 */
class RangeBasedNameEncoder(
        private val collectionNameAllowedRanges: CharacterRanges,
        private val pathSegmentInObjectNameAllowedRanges: CharacterRanges,
        private val replacementChar: Char
) : NameEncoder {

    /**
     * [CharacterRanges] containing all characters that are allowed in the object name and will not be replaced
     * by the [replacementChar].
     */
    private val objectNameAllowedRanges: CharacterRanges = pathSegmentInObjectNameAllowedRanges.buildUpon()
            .addRange('/')
            .build()

    override fun encodeObjectName(objectName: String): String = encode(objectName, objectNameAllowedRanges, replacementChar)

    override fun encodePathSegmentInObjectName(segment: String): String = encode(segment, pathSegmentInObjectNameAllowedRanges, replacementChar)

    override fun encodeCollectionName(collectionName: String): String = encode(collectionName, collectionNameAllowedRanges, replacementChar)

    internal fun encode(original: String, allowedRanges: CharacterRanges, replacementChar: Char): String {
        val sb = StringBuilder(original.length)
        original
                .map { c ->
                    if (!allowedRanges.contains(c)) replacementChar else c
                }
                .forEach { sb.append(it) }
        return sb.toString()
    }
}
