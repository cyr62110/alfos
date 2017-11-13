package fr.cvlaminck.alfos.core.name.path.builder

import fr.cvlaminck.alfos.core.name.path.StorageObjectPath
import fr.cvlaminck.alfos.name.NameEncoder
import fr.cvlaminck.alfos.name.NameValidator

/**
 * Builder class that provides method allowing to easily manipulate object name as virtual path.
 *
 * @param nameValidator
 * @param nameEncoder
 */
class StorageObjectPathBuilder internal constructor(
        private val nameValidator: NameValidator,
        private val nameEncoder: NameEncoder
) {
    private val segments: MutableList<String> = mutableListOf()

    internal constructor(nameValidator: NameValidator, nameEncoder: NameEncoder, segments: Collection<String>) : this(nameValidator, nameEncoder) {
        this.segments.addAll(segments)
    }

    /**
     * Returns the number of segments in the path that will be build.
     */
    val segmentCount: Int
        get() = segments.size

    /**
     * Append a new segment to the path.
     *
     * Segment will be encoded using [nameEncoder] and validated using [nameValidator].
     *
     * @param segment Segment to add to the path.
     * @return this [StorageObjectPathBuilder].
     */
    fun appendPathSegment(segment: String): StorageObjectPathBuilder {
        val encodedSegment = nameEncoder.encodePathSegmentInObjectName(segment)
        return appendRawPathSegment(encodedSegment)
    }

    /**
     * Append a path segment to the path.
     *
     * The segment will not be encoded but still will be validated using [nameValidator].
     *
     * @param segment Segment to add to the path.
     * @return this [StorageObjectPathBuilder].
     */
    fun appendRawPathSegment(segment: String): StorageObjectPathBuilder {
        nameValidator.validatePathSegmentInObjectName(segment)
        segments.add(segment)
        return this
    }

    /**
     * Remove the path segment at [index].
     *
     * @param index Index of the segment to remove.
     * @throws IllegalArgumentException thrown if the [index] is below 0 or equals or greater than the [segmentCount].
     * @return this [StorageObjectPathBuilder].
     */
    fun removePathSegmentAt(index: Int): StorageObjectPathBuilder {
        if (index < 0 || index >= segmentCount) {
            throw IllegalArgumentException("Index ${index} is outside the range [0, ${segmentCount}[.")
        }
        segments.removeAt(index)
        return this
    }

    /**
     * Remove the last path segment. Do nothing is the path is empty.
     *
     * @return this [StorageObjectPathBuilder].
     */
    fun removeLastPathSegment(): StorageObjectPathBuilder {
        if (segmentCount > 0) {
            segments.removeAt(segmentCount - 1)
        }
        return this
    }

    /**
     * Build a new [StorageObjectPath].
     *
     * @return a new [StorageObjectPath].
     */
    fun build(): StorageObjectPath = StorageObjectPath(nameValidator, nameEncoder, segments)

    companion object {
        val PATH_SEPARATOR = "/"
    }
}
