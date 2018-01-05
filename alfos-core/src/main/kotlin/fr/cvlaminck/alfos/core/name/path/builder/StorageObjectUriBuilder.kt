package fr.cvlaminck.alfos.core.name.path.builder

import fr.cvlaminck.alfos.core.name.path.StorageObjectPath
import fr.cvlaminck.alfos.core.name.path.StorageObjectUri
import fr.cvlaminck.alfos.exception.InvalidUriException
import fr.cvlaminck.alfos.name.NameEncoder
import fr.cvlaminck.alfos.name.NameValidator

/**
 * Builder class that provides method allowing to easily construct uri to points to collection or object.
 *
 * This builder is not thread-safe.
 */
class StorageObjectUriBuilder internal constructor(
        private val nameValidator: NameValidator,
        private val nameEncoder: NameEncoder,
        private var providerScheme: String? = null,
        private var collectionName: String? = null,
        private var objectPathBuilder: StorageObjectPathBuilder? = null
) {

    val internalObjectPathBuilder: StorageObjectPathBuilder
        get() {
            if (objectPathBuilder == null) {
                objectPathBuilder = StorageObjectPathBuilder(nameValidator, nameEncoder)
            }
            return objectPathBuilder!!
        }

    fun withScheme(scheme: String): StorageObjectUriBuilder {
        // TODO Implements simple validation for scheme.
        this.providerScheme = scheme
        return this
    }

    fun withCollectionName(collectionName: String): StorageObjectUriBuilder {
        val encodedCollectionName = nameEncoder.encodeCollectionName(collectionName)
        return withRawCollectionName(encodedCollectionName)
    }

    fun withRawCollectionName(collectionName: String): StorageObjectUriBuilder {
        nameValidator.validateCollectionName(collectionName)
        this.collectionName = collectionName
        return this
    }

    fun withObjectPath(objectPath: StorageObjectPath): StorageObjectUriBuilder {
        this.objectPathBuilder = objectPath.buildUpon()
        return this
    }

    fun withObjectName(objectName: String): StorageObjectUriBuilder {
        TODO("Implements when parser are implemented")
        return this
    }

    /**
     * Remove the object name from the uri.
     *
     * @return this builder.
     */
    fun withoutObjectName(): StorageObjectUriBuilder {
        this.objectPathBuilder = null
        return this
    }

    fun appendPathSegment(segment: String): StorageObjectUriBuilder {
        internalObjectPathBuilder.appendPathSegment(segment)
        return this
    }

    fun appendRawPathSegment(segment: String): StorageObjectUriBuilder {
        internalObjectPathBuilder.appendRawPathSegment(segment)
        return this
    }

    fun removePathSegmentAt(index: Int): StorageObjectUriBuilder {
        internalObjectPathBuilder.removePathSegmentAt(index)
        return this
    }

    fun removeLastPathSegment(): StorageObjectUriBuilder {
        internalObjectPathBuilder.removeLastPathSegment()
        return this
    }

    /**
     *
     *
     * @throws InvalidUriException thrown if the scheme or the collection name have not been set.
     */
    fun build(): StorageObjectUri {
        if (providerScheme.isNullOrEmpty()) {
            throw InvalidUriException("Cannot build uri without scheme.")
        }
        if (collectionName.isNullOrEmpty()) {
            throw InvalidUriException("Cannot build uri without collection name.")
        }
        return StorageObjectUri(
                providerScheme!!,
                collectionName!!,
                objectPathBuilder?.build(),
                nameValidator,
                nameEncoder
        )
    }
}
