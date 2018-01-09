package fr.cvlaminck.alfos.core

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.spy
import com.nhaarman.mockito_kotlin.verify
import fr.cvlaminck.alfos.core.name.path.StorageObjectPath
import fr.cvlaminck.alfos.core.name.path.StorageObjectUri
import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.operation.raw.RawStorageCollectionOperations
import fr.cvlaminck.alfos.operation.raw.RawStorageObjectOperations
import fr.cvlaminck.alfos.operation.raw.RawStorageOperations
import fr.cvlaminck.alfos.operation.raw.RawStorageOperationsFactory
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class StorageOperationsManagerTest {

    @Test
    fun getStorageOperations() {
        val storageOperations = mock<RawStorageOperations>()
        val operationsFactory = mock<RawStorageOperationsFactory> {
            on { it.getStorageOperations() } doReturn storageOperations
        }
        val storage = mock<Storage> {
            on { it.operationsFactory } doReturn operationsFactory
        }
        val registry = mock<StorageRegistry> {
            on { it.storages } doReturn setOf(storage)
        }

        val manager = StorageOperationsManager(registry, mock())

        assertNotNull(manager.getStorageOperations(storage).blockingGet())
        verify(storage.operationsFactory).getStorageOperations()
    }

    @Test
    fun getStorageCollectionOperations() {
        val collectionOperations = mock<RawStorageCollectionOperations>()
        val operationsFactory = mock<RawStorageOperationsFactory> {
            on { it.getStorageCollectionOperations("testCollection") } doReturn collectionOperations
        }
        val storage = mock<Storage> {
            on { it.operationsFactory } doReturn operationsFactory
        }
        val registry = mock<StorageRegistry> {
            on { it.storages } doReturn setOf(storage)
        }

        val manager = StorageOperationsManager(registry, mock())

        assertNotNull(manager.getCollectionOperations(storage, "testCollection").blockingGet())
        verify(storage.operationsFactory).getStorageCollectionOperations("testCollection")
    }

    @Test
    fun getStorageCollectionOperations_withUri() {
        val collectionOperations = mock<RawStorageCollectionOperations>()
        val operationsFactory = mock<RawStorageOperationsFactory> {
            on { it.getStorageCollectionOperations("testCollection") } doReturn collectionOperations
        }
        val storage = mock<Storage> {
            on { it.operationsFactory } doReturn operationsFactory
        }
        val registry = mock<StorageRegistry> {
            on { it.findStoragesByProviderScheme("test") } doReturn listOf(storage)
        }
        val uri = StorageObjectUri("test", "testCollection", null, mock(), mock())
        val uriFactory = mock<StorageObjectUriFactory> {
            on { it.parse("test://testCollection") } doReturn uri
        }

        val manager = spy(StorageOperationsManager(registry, uriFactory))

        assertNotNull(manager.getCollectionOperations("test://testCollection").blockingGet())
        verify(uriFactory).parse("test://testCollection")
        verify(manager).getCollectionOperations(uri)
        verify(manager).getCollectionOperations(storage, "testCollection")
    }

    @Test
    fun getStorageObjectOperations() {
        val objectOperations = mock<RawStorageObjectOperations>()
        val operationsFactory = mock<RawStorageOperationsFactory> {
            on { it.getStorageObjectOperations("testCollection", "testObject") } doReturn objectOperations
        }
        val storage = mock<Storage> {
            on { it.operationsFactory } doReturn operationsFactory
        }
        val registry = mock<StorageRegistry> {
            on { it.storages } doReturn setOf(storage)
        }

        val manager = StorageOperationsManager(registry, mock())

        assertNotNull(manager.getObjectOperations(storage, "testCollection", "testObject").blockingGet())
        verify(storage.operationsFactory).getStorageObjectOperations("testCollection", "testObject")
    }

    @Test
    fun getStorageObjectOperations_withUri() {
        val objectOperations = mock<RawStorageObjectOperations>()
        val operationsFactory = mock<RawStorageOperationsFactory> {
            on { it.getStorageObjectOperations("testCollection", "testObject") } doReturn objectOperations
        }
        val storage = mock<Storage> {
            on { it.operationsFactory } doReturn operationsFactory
        }
        val registry = mock<StorageRegistry> {
            on { it.findStoragesByProviderScheme("test") } doReturn listOf(storage)
        }
        val uri = StorageObjectUri("test", "testCollection", StorageObjectPath(mock(), mock(), listOf("testObject")), mock(), mock())
        val uriFactory = mock<StorageObjectUriFactory> {
            on { it.parse("test://testCollection/testObject") } doReturn uri
        }

        val manager = spy(StorageOperationsManager(registry, uriFactory))

        assertNotNull(manager.getObjectOperations("test://testCollection/testObject").blockingGet())
        verify(uriFactory).parse("test://testCollection/testObject")
        verify(manager).getObjectOperations(uri)
        verify(manager).getObjectOperations(storage, "testCollection", "testObject")
    }
}
