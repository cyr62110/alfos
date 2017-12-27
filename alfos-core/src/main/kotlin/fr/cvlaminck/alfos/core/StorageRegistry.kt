package fr.cvlaminck.alfos.core

import fr.cvlaminck.alfos.exception.UnknownProviderException
import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.model.StorageServiceProvider

/**
 * TODO
 */
// FIXME: Make it thread-safe
// FIXME: How to mock without leaving everything open ?
open class StorageRegistry {

    private val _storages: MutableSet<Storage> = hashSetOf()

    /**
     * Collection of all storages that have been registered in this registry.
     */
    open val storages: Set<Storage> = _storages

    /**
     * Collection of all providers that have at least a storage registered in
     * this registry.
     */
    open val providers: Collection<StorageServiceProvider>
        get() = _storages
                .map { it.provider }
                .distinctBy { it.name }

    /**
     * Returns the provider with the given [name].
     *
     * @param name Name of the provider to find.
     * @return the [StorageServiceProvider] with the given [name].
     * @throws UnknownProviderException thrown if no provider with the given [name] has been registered.
     */
    open fun findProviderByName(name: String): StorageServiceProvider = _storages
            .map { it.provider }
            .firstOrNull { it.name == name } ?: throw UnknownProviderException.createWithName(name)

    /**
     * Returns the provider with the given [scheme].
     *
     * @param scheme Scheme of the provider to find.
     * @return the [StorageServiceProvider] with the given [scheme].
     * @throws UnknownProviderException thrown if no provider with the given [scheme] has been registered.
     */
    open fun findProviderByScheme(scheme: String): StorageServiceProvider = _storages
            .map { it.provider }
            .firstOrNull { it.scheme == scheme } ?: throw UnknownProviderException.createWithScheme(scheme)

    /**
     * Returns the provider with the given name or scheme.
     * This function will first try to match by scheme before testing by name.
     *
     * @param nameOrScheme The name or the scheme of the provider to find.
     * @return the [StorageServiceProvider] with the given name or scheme.
     * @throws UnknownProviderException thrown if no provider with the given name or scheme has been registered.
     */
    open fun findProviderByNameOrScheme(nameOrScheme: String): StorageServiceProvider {
        try {
            return findProviderByScheme(nameOrScheme)
        } catch (e : UnknownProviderException) {
            return findProviderByName(nameOrScheme)
        }
    }

    /**
     * Returns all storage that are provided by a provider with a scheme matching the provided scheme.
     *
     * @param providerScheme Scheme of the provider to find storage provided by.
     * @return a list of [Storage].
     */
    open fun findStoragesByProviderScheme(providerScheme: String): List<Storage> = _storages
            .filter { it.provider.scheme == providerScheme }

    open fun registerStorage(storage: Storage) = synchronized(this) {
        _storages.add(storage)
    }
}
