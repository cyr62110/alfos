package fr.cvlaminck.alfos.core

import com.nhaarman.mockito_kotlin.mock
import fr.cvlaminck.alfos.exception.UnknownProviderException
import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.model.StorageServiceProvider
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StorageRegistryTest {

    @Test
    fun providers() {
        val registry = testRegistry
        
        assertEquals(
                listOf(testProvider1, testProvider2).sortedBy { it.name },
                registry.providers.sortedBy { it.name }
        )
    }

    @Test
    fun findProviderWithName() {
        val registry = testRegistry

        assertSame(testProvider1, registry.findProviderByName("TestProvider"))
        assertSame(testProvider2, registry.findProviderByName("TestProvider2"))
        assertThrows(UnknownProviderException::class.java) {
            registry.findProviderByName("TestProvider3")
        }
    }

    @Test
    fun findProviderWithScheme() {
        val registry = testRegistry

        assertSame(testProvider1, registry.findProviderByScheme("test"))
        assertSame(testProvider2, registry.findProviderByScheme("test2"))
        assertThrows(UnknownProviderException::class.java) {
            registry.findProviderByScheme("test3")
        }
    }

    @Test
    fun findProviderWithNameOrScheme() {
        val registry = testRegistry

        assertSame(testProvider1, registry.findProviderByNameOrScheme("TestProvider"))
        assertSame(testProvider1, registry.findProviderByNameOrScheme("test"))
        assertSame(testProvider2, registry.findProviderByNameOrScheme("TestProvider2"))
        assertSame(testProvider2, registry.findProviderByNameOrScheme("test2"))
        assertThrows(UnknownProviderException::class.java) {
            registry.findProviderByNameOrScheme("test3")
        }
    }

    val testProvider1: StorageServiceProvider = mock<StorageServiceProvider> {
        on { it.name }.thenReturn("TestProvider")
        on { it.scheme }.thenReturn("test")
    }

    val testProvider2: StorageServiceProvider = mock<StorageServiceProvider> {
        on { it.name }.thenReturn("TestProvider2")
        on { it.scheme }.thenReturn("test2")
    }

    val testRegistry: StorageRegistry
        get() {
            val storage1 = mock<Storage> {
                on { it.provider }.thenReturn(testProvider1)
            }
            val storage2 = mock<Storage> {
                on { it.provider }.thenReturn(testProvider2)
            }
            val storage3 = mock<Storage> {
                on { it.provider }.thenReturn(testProvider2)
            }

            val registry = StorageRegistry()
            registry.registerStorage(storage1)
            registry.registerStorage(storage2)
            registry.registerStorage(storage3)

            return registry
        }
}
