package fr.cvlaminck.alfos.name

/**
 * Provides method to encode object/collection name provided by the user.
 * The characters that are encoded and
 */
interface NameEncoder {

    /**
     * Encode the provided [objectName] by replacing invalid characters.
     *
     * @param objectName Name of the object to encode.
     * @return Encoded name of the object.
     */
    fun encodeObjectName(objectName: String): String

    /**
     * Encode the provided [segment] by replacing invalid characters.
     *
     * @param segment Path segment that is part of the object name when it is considered as a path.
     * @return Encoded segement.
     */
    fun encodePathSegmentInObjectName(segment: String): String

    /**
     * Encode the provided [collectionName] by replacing invalid characters.
     *
     * @param collectionName Name of the collection to encode.
     * @return Encoded name of the collection.
     */
    fun encodeCollectionName(collectionName: String): String
}
