package fr.cvlaminck.alfos.core

import fr.cvlaminck.alfos.core.name.encoder.DummyNameEncoder
import fr.cvlaminck.alfos.core.name.encoder.SafeNameEncoder
import fr.cvlaminck.alfos.core.name.path.StorageObjectUri
import fr.cvlaminck.alfos.core.name.path.builder.StorageObjectUriBuilder
import fr.cvlaminck.alfos.core.name.path.parser.StorageObjectUriParser
import fr.cvlaminck.alfos.core.name.validator.SafeNameValidator

/**
 * TODO
 */
class StorageObjectUriFactory(
        private val registry: StorageRegistry
) {

    private val objectNameFactory: StorageObjectNameFactory = StorageObjectNameFactory(registry)

    /**
     * Returns a new [StorageObjectUriBuilder] that will validate the uri according to the rules of the provider
     * with the given name or scheme.
     *
     * The uri will only be validated against the rule of the provider. This uri will only be usable for the
     * given provider. If you want to ensure that your objects have the same naming across different storage
     * provider, use [newSafeUriBuilder] instead.
     *
     * @param providerNameOrScheme Name or scheme of the provider we want an uri for.
     * @return a new [StorageObjectUriBuilder] that will validate against the rule of the provider.
     */
    fun newUriBuilder(providerNameOrScheme: String): StorageObjectUriBuilder {
        val provider = registry.findProviderByNameOrScheme(providerNameOrScheme)
        return StorageObjectUriBuilder(provider.nameValidator, DummyNameEncoder())
                .withScheme(provider.scheme)
    }

    /**
     * Returns a new [StorageObjectUriBuilder] that will validate and encode the different part of the uri to make sure
     * that object and collection will have the same name across the different provider.
     *
     * @return a new safe [StorageObjectUriBuilder].
     */
    fun newSafeUriBuilder(): StorageObjectUriBuilder =
            StorageObjectUriBuilder(SafeNameValidator(), SafeNameEncoder())

    /**
     * Parse the provided raw string and returns a valid [StorageObjectUri].
     *
     * A provider handling the scheme of the uri must have been registered into the [storageRegistry]
     * before parsing. This will ensure that the uri is valid according to the rules of the provider
     * matching the scheme.
     *
     * @param uri Raw string to parse into a [StorageObjectUri].
     * @return a valid [StorageObjectUri].
     */
    fun parse(uri: String): StorageObjectUri =
            StorageObjectUriParser(registry, DummyNameEncoder()).parse(uri)
}
