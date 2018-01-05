package fr.cvlaminck.alfos.core

import fr.cvlaminck.alfos.core.name.encoder.DummyNameEncoder
import fr.cvlaminck.alfos.core.name.encoder.SafeNameEncoder
import fr.cvlaminck.alfos.core.name.path.StorageObjectPath
import fr.cvlaminck.alfos.core.name.path.builder.StorageObjectPathBuilder
import fr.cvlaminck.alfos.core.name.path.parser.StorageObjectPathParser
import fr.cvlaminck.alfos.core.name.validator.SafeNameValidator

/**
 * TODO
 */
class StorageObjectNameFactory(
        private val registry: StorageRegistry
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
        val provider = registry.findProviderByName(providerName)
        return StorageObjectPathBuilder(provider.nameValidator, DummyNameEncoder())
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

    /**
     * Parse the provided raw string into a valid [StorageObjectPath].
     *
     * The path will be validated against the rule of the provider with the given [providerName].
     *
     * @param providerName Name of the provider which will validate the path.
     * @param path Raw string to parse into a [StorageObjectPath].
     * @return a valid [StorageObjectPath].
     */
    fun parse(providerName: String, path: String): StorageObjectPath {
        val provider = registry.findProviderByName(providerName)
        return StorageObjectPathParser(provider.nameValidator, DummyNameEncoder()).parse(path)
    }
}
