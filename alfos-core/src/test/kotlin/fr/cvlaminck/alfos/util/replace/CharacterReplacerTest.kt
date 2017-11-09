package fr.cvlaminck.alfos.util.replace

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CharacterReplacerTest {

    @Test
    fun stringWithOverFFFFCodePoints() {
        val unicodeString = String(Character.toChars(0x1f61b))
        assertEquals(1, unicodeString.codePoints().count())
    }


}
