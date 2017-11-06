package fr.cvlaminck.alfos.exception

/**
 * Thrown when the user provides an invalid name either for a collection or an object.
 */
class InvalidNameException(
        message: String
) : AlfosRuntimeException(message)
