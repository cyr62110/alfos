package fr.cvlaminck.alfos.util.replace

import fr.cvlaminck.alfos.util.range.CharacterRanges

/**
 * Utility class to allow to replace all characters that are not contains in the provide [allowedCharacterRanges] by the
 * [replacementCharCodePoint].
 *
 * @constructor Instantiate a new [CharacterReplacer].
 *
 * @param allowedCharactersRange Collection of range containing the characters that will not be replace.
 * @param replacementCharCodePoint Unicode code point of the replacement character for characters outside ranges.
 */
class CharacterReplacer(
        private val allowedCharactersRanges: CharacterRanges,
        private val replacementCharCodePoint: Int
) {

    /**
     * Instantiate a new [CharacterReplacer].
     *
     * @param allowedCharactersRange Collection of range containing the characters that will not be replace.
     * @param replacementChar Replacement character for characters outside ranges.
     */
    constructor(allowedCharactersRanges: CharacterRanges, replacementChar: Char) : this(allowedCharactersRanges, replacementChar.toInt())

    /**
     * Replace all characters outside of the [allowedCharactersRanges] in the [input] by the [replacementCharCodePoint].
     *
     * @param input [String] in which the characters must be replaced.
     * @return a [String] with all characters outside of range replaced.
     */
    fun replaceIn(input: String): String {
        val sb = StringBuilder(input.length)
        input.codePoints()
                .forEach { codePoint ->
                    if (allowedCharactersRanges.contains(codePoint)) {
                        sb.appendCodePoint(codePoint)
                    } else {
                        sb.appendCodePoint(replacementCharCodePoint)
                    }
                }
        return sb.toString()
    }
}
