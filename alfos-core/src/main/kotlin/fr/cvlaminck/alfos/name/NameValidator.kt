package fr.cvlaminck.alfos.name

/**
 * Provides methods to validate object and collection name.
 */
interface NameValidator {

    /**
     * Check that the provide object name is valid for the provider.
     * Otherwise throw an [InvalidObjectNameException].
     *
     * @param objectName Name of the object to check.
     * @throws InvalidObjectNameException if the [objectName] is not valid.
     */
    fun validateObjectName(objectName: String)

    /**
     * Check that the provided path segment is valid when the object name is considered as a path.
     * Otherwise throw an [InvalidObjectNameException].
     *
     * @param segment Path segment to check.
     * @throws InvalidObjectNameException if the [segment] is not valid.
     */
    fun validatePathSegmentInObjectName(segment: String)

    /**
     * Check that the provided collection name is valid for the provider.
     * Otherwise throw an [InvalidObjectNameException].
     */
    fun validateCollectionName(collectionName: String)
}
