package fr.cvlaminck.alfos.name.encoder

import fr.cvlaminck.alfos.util.CharacterRange

/**
 *
 */
class RangeBasedNameEncoder(
        private val bucketNameAllowedRanges: List<CharacterRange>,
        private val objectNameAllowedRanges: List<CharacterRange>,
        private val replacementChar: Char
) : NameEncoder {

}
