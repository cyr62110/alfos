package fr.cvlaminck.alfos.core.name.path.builder

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import fr.cvlaminck.alfos.name.NameEncoder
import fr.cvlaminck.alfos.name.NameValidator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class StorageObjectPathBuilderTest {

    @Test
    fun appendRawPathSegment() {
        val nameValidator = mock<NameValidator>()
        val builder = StorageObjectPathBuilder(nameValidator, mock<NameEncoder>())
                .appendRawPathSegment("Hello_World")

        verify(nameValidator).validatePathSegmentInObjectName("Hello_World")
        assertEquals(1, builder.segmentCount)
        assertEquals("Hello_World", builder.build().segments[0])
    }

    @Test
    fun appendPathSegment() {
        val nameValidator = mock<NameValidator>()
        val nameEncoder = mock<NameEncoder> {
            on { it.encodePathSegmentInObjectName("Hello World") }.thenReturn("Hello_World")
        }
        val builder = StorageObjectPathBuilder(nameValidator, nameEncoder)
                .appendPathSegment("Hello World")

        verify(nameValidator).validatePathSegmentInObjectName("Hello_World")
        assertEquals(1, builder.segmentCount)
        assertEquals("Hello_World", builder.build().segments[0])
    }

    @Test
    fun removePathSegmentAt() {
        val builder = StorageObjectPathBuilder(mock(), mock())
                .appendRawPathSegment("1")
                .appendRawPathSegment("2")
                .appendRawPathSegment("3")

        builder.removePathSegmentAt(1)

        val path = builder.build()
        assertEquals(2, builder.segmentCount)
        assertEquals("1", path.segments[0])
        assertEquals("3", path.segments[1])
    }

    @Test
    fun removePathSegmentAt_throwOutOfBoundsException() {
        val builder = StorageObjectPathBuilder(mock(), mock())
                .appendRawPathSegment("1")

        assertThrows(IndexOutOfBoundsException::class.java) {
            builder.removePathSegmentAt(-1)
        }
        assertThrows(IndexOutOfBoundsException::class.java) {
            builder.removePathSegmentAt(2)
        }
    }

    @Test
    fun removeLastPathSegment() {
        val builder = StorageObjectPathBuilder(mock(), mock())
                .appendRawPathSegment("1")

        builder.removeLastPathSegment()

        assertEquals(0, builder.segmentCount)

        builder.removeLastPathSegment()

        assertEquals(0, builder.segmentCount)
    }
}
