package fr.cvlaminck.alfos.util.range

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CharacterRangeTest {

    @Test
    fun containsChar() {
        assertTrue(CharacterRange('a', 'z').contains('a'))
        assertTrue(CharacterRange('a', 'z').contains('f'))
        assertTrue(CharacterRange('a', 'z').contains('z'))

        assertFalse(CharacterRange('a', 'z').contains('A'))
    }
}
