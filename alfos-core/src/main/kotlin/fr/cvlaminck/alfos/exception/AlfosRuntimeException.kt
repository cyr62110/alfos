package fr.cvlaminck.alfos.exception

/**
 * Base class of all runtime exceptions thrown by the library.
 */
open class AlfosRuntimeException(
        message: String?,
        cause: Throwable?
) : RuntimeException(message, cause) {
    constructor(message: String) : this(message, null)
}
