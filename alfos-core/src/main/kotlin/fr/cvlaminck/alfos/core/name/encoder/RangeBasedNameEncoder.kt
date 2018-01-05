package fr.cvlaminck.alfos.core.name.encoder

import fr.cvlaminck.alfos.name.NameEncoder
import fr.cvlaminck.alfos.util.range.CharacterRanges
import fr.cvlaminck.alfos.util.replace.CharacterReplacer

/**
 * Implementation of [NameEncoder] that can be configured using [CharacterRanges] to determine which characters are
 * allowed in collection/object name. All other characters will be replaced by the [replacementChar].
 *
 * @param collectionNameAllowedRanges [CharacterRanges] containing all characters that are allowed in collection
 * name and will not be replaced by the replacement character.
 * @param pathSegmentInObjectNameAllowedRanges [CharacterRanges] containing all characters that are allowed in path
 * segment forming the object name and will not be replaced by the [replacementChar].
 * @param collectionNameReplacementChar Character that will be used to replace invalid characters in collection name.
 * @param objectNameReplacementChar Character that will be used to replace invalid characters in object name.
 */
class RangeBasedNameEncoder(
        collectionNameAllowedRanges: CharacterRanges,
        pathSegmentInObjectNameAllowedRanges: CharacterRanges,
        collectionNameReplacementChar: Char,
        objectNameReplacementChar: Char
) : NameEncoder {

    private val collectionNameCharacterReplacer = CharacterReplacer(collectionNameAllowedRanges, collectionNameReplacementChar)
    private val pathSegmentInObjectNameCharacterReplacer = CharacterReplacer(pathSegmentInObjectNameAllowedRanges, objectNameReplacementChar)
    private val objectNameCharacterReplacer = CharacterReplacer(pathSegmentInObjectNameAllowedRanges.buildUpon().addRange('/').build(), objectNameReplacementChar)

    override fun encodeObjectName(objectName: String): String = objectNameCharacterReplacer.replaceIn(objectName)

    override fun encodePathSegmentInObjectName(segment: String): String = pathSegmentInObjectNameCharacterReplacer.replaceIn(segment)

    override fun encodeCollectionName(collectionName: String): String = collectionNameCharacterReplacer.replaceIn(collectionName)
}
