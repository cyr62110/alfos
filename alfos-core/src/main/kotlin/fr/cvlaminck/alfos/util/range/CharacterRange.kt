package fr.cvlaminck.alfos.util.range

/**
 * A range of characters.
 *
 * @constructor Create a new range containing all characters between [startCharacterCodePoint] and [endCharacterCodePoint] inclusive.
 * @param startCharacterCodePoint Unicode code point of the first character contained in the range.
 * @param endCharacterCodePoint Unicode code point of the last character contained in the range. Must be greater than [startCharacterCodePoint].
 */
class CharacterRange(
        val startCharacterCodePoint: Int,
        val endCharacterCodePoint: Int
) {

    /**
     * Create a new range containing all characters between [startCharacter] and [endCharacter] inclusive.
     * @param startCharacter First character contained in the range.
     * @param lastCharacter Last character contained in the range.
     */
    constructor(startCharacter: Char, endCharacter: Char) : this(startCharacter.toInt(), endCharacter.toInt())

    /**
     * Create a new range including [char] as only character.
     *
     * @param char Only character contained in the range.
     */
    constructor(char: Char) : this(char, char)

    /**
     * Returns true if the unicode code of the provided [char] is between [startCharacterCodePoint] and
     * [endCharacterCodePoint].
     *
     * @return true if the [char] is in the range, false otherwise.
     */
    fun contains(char: Char): Boolean = char.toInt() in startCharacterCodePoint..endCharacterCodePoint

    /**
     * Return true if the provided [codePoint] is between [startCharacterCodePoint] and [endCharacterCodePoint].
     *
     * @return true if the [codePoint] is in the range, false otherwise.
     */
    fun contains(codePoint: Int): Boolean = codePoint in startCharacterCodePoint..endCharacterCodePoint
}
