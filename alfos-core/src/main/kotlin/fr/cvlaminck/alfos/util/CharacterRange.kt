package fr.cvlaminck.alfos.util

/**
 * A range of characters.
 *
 * @constructor Create a new range containing all characters between [startCharacter] and [endCharacter] inclusive.
 * @param startCharacter First character contained in the range.
 * @param endCharacter Last character contained in the range. Unicode code of this character must be greater than [startCharacter].
 */
class CharacterRange(
        val startCharacter: Char,
        val endCharacter: Char
) {

    /**
     * Create a new range including [char] as only character.
     *
     * @param char Only character contained in the range.
     */
    constructor(char: Char) : this (char, char)

    /**
     * Returns true if the unicode code of the provided [char] is a number between the unicode codes of the [startCharacter] and
     * the [endCharacter].
     *
     * @return true if the [char] is in the range, false otherwise.
     */
    fun contains(char: Char): Boolean = char in startCharacter..endCharacter
}
