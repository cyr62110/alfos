package fr.cvlaminck.alfos.util.replace

import fr.cvlaminck.alfos.util.range.CharacterRange
import fr.cvlaminck.alfos.util.range.CharacterRanges
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CharacterReplacerTest {

    @Test
    fun stringWithOverFFFFCodePoints() {
        val unicodeString = String(Character.toChars(0x1f61b))
        assertEquals(1, unicodeString.codePoints().count())
    }

    @Test
    fun replace() {
        val allowedRanges = CharacterRanges.Builder()
                .addRange('a', 'z')
                .addRange('A', 'Z')
                .addRange('_')
                .build()
        val replacer = CharacterReplacer(allowedRanges, '_')

        assertEquals("Hello_world", replacer.replaceIn("Hello world"))
        assertEquals("Hello_world", replacer.replaceIn("Hello_world"))

        val unicodeString = StringBuilder()
                .append("Hello world ")
                .appendCodePoint(0x1f603)
                .toString()
        assertEquals("Hello_world__", replacer.replaceIn(unicodeString))
    }
}
