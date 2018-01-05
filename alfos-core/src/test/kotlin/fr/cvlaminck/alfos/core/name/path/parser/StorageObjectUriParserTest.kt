package fr.cvlaminck.alfos.core.name.path.parser

import com.nhaarman.mockito_kotlin.mock
import fr.cvlaminck.alfos.core.StorageRegistry
import fr.cvlaminck.alfos.core.name.encoder.DummyNameEncoder
import fr.cvlaminck.alfos.core.name.path.StorageObjectPath
import fr.cvlaminck.alfos.exception.InvalidUriException
import fr.cvlaminck.alfos.exception.UnknownProviderException
import fr.cvlaminck.alfos.model.StorageServiceProvider
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StorageObjectUriParserTest {

    @Test
    fun parseProviderFromUri() {
        val provider1 = mock<StorageServiceProvider>()
        val provider2 = mock<StorageServiceProvider>()
        val registry = mock<StorageRegistry> {
            on { it.findProviderByScheme("testscheme1") }.thenReturn(provider1)
            on { it.findProviderByScheme("testscheme2") }.thenReturn(provider2)
            on { it.findProviderByScheme("testscheme3") }.thenThrow(UnknownProviderException::class.java)
        }

        val uriParser = StorageObjectUriParser(registry, mock())

        assertSame(provider1, uriParser.parseProviderFromUri("testscheme1://testcollection1/testobject1"))
        assertSame(provider2, uriParser.parseProviderFromUri("testscheme2://testcollection2/testdir2/testobject2"))

        assertThrows(InvalidUriException::class.java, { uriParser.parseProviderFromUri("testscheme1:/testcollection1") })
        assertThrows(UnknownProviderException::class.java, { uriParser.parseProviderFromUri("testscheme3://testcollection3") })
    }

    @Test
    fun parseCollectionFromUri() {
        val provider = mock<StorageServiceProvider> {
            on { it.scheme }.thenReturn("testscheme")
        }

        val uriParser = StorageObjectUriParser(mock(), mock())

        assertEquals("testcollection1", uriParser.parseCollectionFromUri("testscheme://testcollection1", provider))
        assertEquals("testcollection2", uriParser.parseCollectionFromUri("testscheme://testcollection2/", provider))
        assertEquals("testcollection3", uriParser.parseCollectionFromUri("testscheme://testcollection3/testobject3", provider))

        assertThrows(InvalidUriException::class.java, { uriParser.parseCollectionFromUri("testscheme://", provider) })
    }

    @Test
    fun parsePathFromUri() {
        val provider = mock<StorageServiceProvider> {
            on { it.scheme }.thenReturn("testscheme")
            on { it.nameValidator }.thenReturn(mock())
        }

        val uriParser = StorageObjectUriParser(mock(), DummyNameEncoder())

        assertEquals(
                StorageObjectPath(mock(), mock(), listOf("testpath")),
                uriParser.parsePathFromUri("testscheme://testcollection/testpath", provider, "testcollection")
        )
        assertNull(uriParser.parsePathFromUri("testscheme://testcollection", provider, "testcollection"))
        assertNull(uriParser.parsePathFromUri("testscheme://testcollection/", provider, "testcollection"))
    }
}
