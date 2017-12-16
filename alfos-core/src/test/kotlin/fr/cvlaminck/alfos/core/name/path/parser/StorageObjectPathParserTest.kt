package fr.cvlaminck.alfos.core.name.path.parser

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.spy
import com.nhaarman.mockito_kotlin.verify
import fr.cvlaminck.alfos.core.name.encoder.DummyNameEncoder
import fr.cvlaminck.alfos.core.name.path.StorageObjectPath
import fr.cvlaminck.alfos.name.NameValidator
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class StorageObjectPathParserTest {

    @Test
    fun parse() {
        val encoder = spy(DummyNameEncoder())
        val validator = mock<NameValidator>()

        val parser = StorageObjectPathParser(validator, encoder, '/')

        assertEquals(
                parser.parse("testpath1"),
                StorageObjectPath(mock(), mock(), listOf("testpath1"))
        )
        verify(encoder).encodePathSegmentInObjectName("testpath1")
        verify(validator).validatePathSegmentInObjectName("testpath1")

        assertEquals(
                parser.parse("testpath1/testpath2"),
                StorageObjectPath(mock(), mock(), listOf("testpath1", "testpath2"))
        )
    }
}
