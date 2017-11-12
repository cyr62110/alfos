package fr.cvlaminck.alfos.core.name

import fr.cvlaminck.alfos.util.range.CharacterRanges

/**
 * Object providing [CharacterRanges] that are safe for collection and object names.
 */
object SafeNameCharacterRanges {

    val COLLECTION_NAME_SAFE_RANGES = CharacterRanges.Builder()
            .addRange('a', 'z')
            .addRange('0', '9')
            .addRanges('.', '-')
            .build()

    val PATH_SEGMENT_SAFE_RANGES = CharacterRanges.Builder()
            .addRange('a', 'z')
            .addRange('A', 'Z')
            .addRange('0', '9')
            .addRanges('!', '-', '_', '.', '*', '\'', '(', ')')
            .build()
}
