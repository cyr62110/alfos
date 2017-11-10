package fr.cvlaminck.alfos.core.name.encoder

import fr.cvlaminck.alfos.name.NameEncoder
import fr.cvlaminck.alfos.util.range.CharacterRanges
import fr.cvlaminck.alfos.util.replace.CharacterReplacer

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
        val collectionNameAllowedRanges: CharacterRanges,
        val pathSegmentInObjectNameAllowedRanges: CharacterRanges,
        val replacementChar: Char
) : NameEncoder {

    private val collectionNameCharacterReplacer = CharacterReplacer(collectionNameAllowedRanges, replacementChar)
    private val pathSegmentInObjectNameCharacterReplacer = CharacterReplacer(pathSegmentInObjectNameAllowedRanges, replacementChar)
    private val objectNameCharacterReplacer = CharacterReplacer(pathSegmentInObjectNameAllowedRanges.buildUpon().addRange('/').build(), replacementChar)

    override fun encodeObjectName(objectName: String): String = objectNameCharacterReplacer.replaceIn(objectName)

    override fun encodePathSegmentInObjectName(segment: String): String = pathSegmentInObjectNameCharacterReplacer.replaceIn(segment)

    override fun encodeCollectionName(collectionName: String): String = collectionNameCharacterReplacer.replaceIn(collectionName)
}
