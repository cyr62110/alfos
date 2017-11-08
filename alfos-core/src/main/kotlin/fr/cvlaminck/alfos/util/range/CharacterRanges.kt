package fr.cvlaminck.alfos.util.range

/**
 * Immutable collection of characters that provides utility methods to manipulate multiple [CharacterRange].
 * It must constructed using a [Builder] and [Builder.addRange] methods.
 *
 * @constructor Private constructor. Use [Builder] instead in public API.
 * @param characterRanges Collection of [CharacterRange] contained in this collection.
 */
class CharacterRanges private constructor (
        private val characterRanges: Collection<CharacterRange>
) {

    /**
     * Returns true if the provided [character] is contained in one of the [CharacterRange] contained in this collection.
     *
     * @param character Character to check.
     * @return true if [character] is contained in one [CharacterRange], false otherwise.
     */
    fun contains(character: Char): Boolean = characterRanges.any { it.contains(character) }

    /**
     * Returns true if the Unicode [characterCodePoint] is contained in one of the [CharacterRange] contained in this collection.
     *
     * @param characterCodePoint Unicode code point of the character to check.
     * @return true if [character] is contained in one [CharacterRange], false otherwise.
     */
    fun contains(characterCodePoint: Int): Boolean = characterRanges.any { it.contains(characterCodePoint) }

    /**
     * Create a new [Builder] already containing all the [CharacterRange] contained in this collection.
     *
     * @return a new [Builder].
     */
    fun buildUpon(): Builder = Builder(ArrayList(characterRanges))

    class Builder internal constructor(
            private val characterRanges: MutableList<CharacterRange> = arrayListOf()
    ) {

        fun addRange(range: CharacterRange): Builder {
            characterRanges.add(range)
            return this
        }

        fun addRange(startCharacter: Char, endCharacter: Char): Builder = addRange(CharacterRange(startCharacter, endCharacter))

        fun addRange(character: Char): Builder = addRange(CharacterRange(character))

        fun build(): CharacterRanges = CharacterRanges(characterRanges)
    }
}
