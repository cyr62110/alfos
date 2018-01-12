package fr.cvlaminck.alfos.operation

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.spy
import fr.cvlaminck.alfos.model.StorageObject
import fr.cvlaminck.alfos.operation.raw.RawStorageObjectOperations
import io.reactivex.Maybe
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class StorageObjectOperationsTest {

    @Test
    fun exists_true() {
        val storageObject = mock<StorageObject>()
        val rawOperations = mock<RawStorageObjectOperations> {
            on { it.getInformation() } doReturn Maybe.just(storageObject)
        }
        val operations = spy(StorageObjectOperations(mock(), "testCollection", "testObject", rawOperations))

        assertTrue(operations.exists().blockingGet())
    }

    @Test
    fun exists_false() {
        val rawOperations = mock<RawStorageObjectOperations> {
            on { it.getInformation() } doReturn Maybe.empty()
        }
        val operations = spy(StorageObjectOperations(mock(), "testCollection", "testObject", rawOperations))

        assertFalse(operations.exists().blockingGet())
    }
}
