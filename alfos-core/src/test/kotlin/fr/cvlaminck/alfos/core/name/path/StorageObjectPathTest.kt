package fr.cvlaminck.alfos.core.name.path

import com.nhaarman.mockito_kotlin.mock
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class StorageObjectPathTest {

    @Test
    fun equals() {
        assertEquals(
                StorageObjectPath(mock(), mock(), listOf("testpath1")),
                StorageObjectPath(mock(), mock(), listOf("testpath1"))
        )
        assertEquals(
                StorageObjectPath(mock(), mock(), listOf("testpath1", "testpath2")),
                StorageObjectPath(mock(), mock(), listOf("testpath1", "testpath2"))
        )

        assertNotEquals(
                StorageObjectPath(mock(), mock(), listOf("testpath1")),
                StorageObjectPath(mock(), mock(), listOf("testpath2"))
        )
        assertNotEquals(
                StorageObjectPath(mock(), mock(), listOf("testpath1", "testpath2")),
                StorageObjectPath(mock(), mock(), listOf("testpath2", "testpath1"))
        )
    }
}
