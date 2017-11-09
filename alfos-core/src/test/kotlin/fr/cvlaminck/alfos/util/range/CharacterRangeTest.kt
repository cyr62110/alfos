package fr.cvlaminck.alfos.util.range

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CharacterRangeTest {

    @Test
    fun contains_char() {
        assertTrue(CharacterRange('a', 'z').contains('a'))
        assertTrue(CharacterRange('a', 'z').contains('f'))
        assertTrue(CharacterRange('a', 'z').contains('z'))
        assertTrue(CharacterRange(0x61, 0x7a).contains('a'))
        assertTrue(CharacterRange(0x61, 0x7a).contains('f'))
        assertTrue(CharacterRange(0x61, 0x7a).contains('z'))

        assertFalse(CharacterRange('a', 'z').contains('A'))
        assertFalse(CharacterRange(0x1f600, 0x1f64f).contains('a'))
    }

    @Test
    fun contains_unicodeCodePoint() {
        assertTrue(CharacterRange('a', 'z').contains(0x61))
        assertTrue(CharacterRange('a', 'z').contains(0x66))
        assertTrue(CharacterRange('a', 'z').contains(0x7a))
        assertTrue(CharacterRange(0x1f600, 0x1f64f).contains(0x1f600))
        assertTrue(CharacterRange(0x1f600, 0x1f64f).contains(0x1f61e))
        assertTrue(CharacterRange(0x1f600, 0x1f64f).contains(0x1f64f))

        assertFalse(CharacterRange('a', 'z').contains(0x41))
        assertFalse(CharacterRange(0x1f600, 0x1f64f).contains(0x41))
    }
}
