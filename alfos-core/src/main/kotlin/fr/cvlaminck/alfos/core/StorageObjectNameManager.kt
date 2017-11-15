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
     * Create a new [StorageObjectPathBuilder] that will validate segments according to the naming rules of
     * the given provider.
     *
     * The [StorageObjectPathBuilder] will not transform the object name, it will only validate it against the naming
     * rule of the provider. As it is validated against the provider naming rules, the generated object name may only
     * be usable for this provider. If your goal is to generate an object name that is usable accross providers, use
     * [newSafePathBuilder] instead.
     *
     * @param providerName Name of the provider on which the object is/will be hosted.
     * @return a new [StorageObjectPathBuilder] configured for the given provider.
     */
    fun newPathBuilder(providerName: String): StorageObjectPathBuilder {
        TODO("not implemented")
    }

    /**
     * Create a [StorageObjectPathBuilder] that will validate and encode segments according to safe naming rules.
     *
     * A safe [StorageObjectPathBuilder] will encode segments using a [SafeNameEncoder]. This allow the object
     * to have the same name across the different provider.
     *
     * @return a new [StorageObjectPathBuilder] configure with a [SafeNameEncoder] and a [SafeNameValidator].
     */
    fun newSafePathBuilder(): StorageObjectPathBuilder =
            StorageObjectPathBuilder(SafeNameValidator(), SafeNameEncoder())
}
