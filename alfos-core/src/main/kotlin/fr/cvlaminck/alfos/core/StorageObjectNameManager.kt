package fr.cvlaminck.alfos.core

import fr.cvlaminck.alfos.core.name.encoder.SafeNameEncoder
import fr.cvlaminck.alfos.core.name.path.builder.StorageObjectPathBuilder
import fr.cvlaminck.alfos.core.name.validator.SafeNameValidator

/**
 *
 */
class StorageObjectNameManager(
        private val storageRegistry: StorageRegistry
) {

    /**
     * Create a new [StorageObjectPathBuilder] that will validate and encode segments according to the naming
     * rules of the given provider.
     *
     * [StorageObjectPath] created using returned [StorageObjectPathBuilder] may not be usable for any other provider.
     * If you want your object to have an interoperable naming, use [newSafePathBuilder] instead.
     *
     * @param providerName Name of the provider on which the object is/will be hosted.
     * @return a new [StorageObjectPathBuilder] configured for the given provider.
     */
    fun newPathBuilder(providerName: String): StorageObjectPathBuilder {
        TODO("not implemented")
    }

    /**
     * Create a [StorageObjectPathBuilder] that will validate and encode segments according to naming rules that
     * allow the object to have the exact same name on all providers supported by the library.
     *
     * @return a new [StorageObjectPathBuilder] configure with a [SafeNameEncoder] and a [SafeNameValidator].
     */
    fun newSafePathBuilder(): StorageObjectPathBuilder =
            StorageObjectPathBuilder(SafeNameValidator(), SafeNameEncoder())
}
