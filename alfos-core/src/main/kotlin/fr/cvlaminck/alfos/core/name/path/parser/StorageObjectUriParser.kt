package fr.cvlaminck.alfos.core.name.path.parser

import fr.cvlaminck.alfos.core.StorageRegistry
import fr.cvlaminck.alfos.core.name.path.StorageObjectPath
import fr.cvlaminck.alfos.core.name.path.StorageObjectUri
import fr.cvlaminck.alfos.exception.InvalidUriException
import fr.cvlaminck.alfos.model.StorageServiceProvider
import fr.cvlaminck.alfos.name.NameEncoder

internal class StorageObjectUriParser (
        private val storageRegistry: StorageRegistry,
        private val nameEncoder: NameEncoder
) {

    fun parse(sUri: String): StorageObjectUri {
        val provider = parseProviderFromUri(sUri)
        val collection = parseCollectionFromUri(sUri, provider)
        val path = parsePathFromUri(sUri, provider, collection)
        return StorageObjectUri(
                provider.scheme,
                collection,
                path,
                provider.nameValidator,
                nameEncoder
        )
    }

    internal fun parseProviderFromUri(sUri: String): StorageServiceProvider {
        val indexOfSchemeSeparator = sUri.indexOf(StorageObjectUri.SCHEME_SEPARATOR)
        if (indexOfSchemeSeparator <= 0) {
            throw InvalidUriException("Cannot parse uri without scheme.")
        }
        val scheme = sUri.substring(0, indexOfSchemeSeparator)
        return storageRegistry.findProviderByScheme(scheme)
    }

    internal fun parseCollectionFromUri(sUri: String, provider: StorageServiceProvider): String {
        val indexOfFirstCharOfCollection = provider.scheme.length + StorageObjectUri.SCHEME_SEPARATOR.length
        if (indexOfFirstCharOfCollection >= sUri.length) {
            throw InvalidUriException("Cannot parse uri without collection.")
        }
        val indexOfFirstPathSeparator = sUri.indexOf(StorageObjectPath.PATH_SEPARATOR, indexOfFirstCharOfCollection)
        return if (indexOfFirstPathSeparator == -1) {
            sUri.substring(indexOfFirstCharOfCollection)
        } else {
            sUri.substring(indexOfFirstCharOfCollection, indexOfFirstPathSeparator)
        }
    }

    internal fun parsePathFromUri(sUri: String, provider: StorageServiceProvider, collection: String): StorageObjectPath? {
        val indexOfFirstCharOfPath = provider.scheme.length + StorageObjectUri.SCHEME_SEPARATOR.length + collection.length + 1
        return if (indexOfFirstCharOfPath < sUri.length) {
            StorageObjectPathParser(provider.nameValidator, nameEncoder)
                    .parse(sUri, indexOfFirstCharOfPath)
        } else null
    }
}
