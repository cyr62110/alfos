package fr.cvlaminck.alfos.api.exception

/**
 * Base class of all exception returned to the user through the API.
 *
 * NOTE: Internally used exception may not inherit from this class.
 */
open class AlfosApiException(
        message: String?,
        cause: Throwable?
) : RuntimeException(message, cause) {

    constructor(message: String) : this(message, null)
}
