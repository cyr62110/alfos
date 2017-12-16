package fr.cvlaminck.alfos.core.name.path.builder

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import fr.cvlaminck.alfos.core.name.path.StorageObjectPath
import fr.cvlaminck.alfos.name.NameEncoder
import fr.cvlaminck.alfos.name.NameValidator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StorageObjectUriBuilderTest {

    @Test
    fun withScheme() {
        val builder = StorageObjectUriBuilder(mock(), mock(), null, "testcollection")
                .withScheme("testscheme")

        val uri = builder.build()
        assertEquals("testscheme", uri.providerScheme)
    }

    @Test
    fun withRawCollectionName() {
        val validator = mock<NameValidator>()
        val builder = StorageObjectUriBuilder(validator, mock(), "testscheme")
                .withRawCollectionName("testcollection")

        val uri = builder.build()
        assertEquals("testcollection", uri.collectionName)
        verify(validator).validateCollectionName("testcollection")
    }

    @Test
    fun withCollectionName() {
        val encoder = mock<NameEncoder> {
            on { encodeCollectionName("testcollection") }.thenReturn("encodedtestcollection")
        }
        val validator = mock<NameValidator> ()

        val builder = StorageObjectUriBuilder(validator, encoder, "testscheme")
                .withCollectionName("testcollection")

        val uri = builder.build()
        assertEquals("encodedtestcollection", uri.collectionName)
        verify(validator).validateCollectionName("encodedtestcollection")
    }

    @Test
    fun withObjectPath() {
        val path = StorageObjectPath(mock(), mock(), listOf("testpath"));

        val builder = StorageObjectUriBuilder(mock(), mock(), "testscheme", "testcollection")
                .withObjectPath(path)

        val uri = builder.build()
        assertEquals(path, uri.objectPath)
    }

    @Test
    fun withoutObjectName() {
        val path = StorageObjectPath(mock(), mock(), listOf("testpath"))

        val builder = StorageObjectUriBuilder(mock(), mock(), "testscheme", "testcollection", path.buildUpon())
                .withoutObjectName()

        val uri = builder.build()
        assertNull(uri.objectPath)
    }
}
