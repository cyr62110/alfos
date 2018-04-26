package fr.cvlaminck.alfos.api.exception

/**
 * Exception thrown if an operation is executed on an object (blob, bucket or storage) that does not
 * exists in the storage.
 */
class ObjectNotExistException (
        id: String
) : AlfosApiException("Object '${id}' does not exists.")
