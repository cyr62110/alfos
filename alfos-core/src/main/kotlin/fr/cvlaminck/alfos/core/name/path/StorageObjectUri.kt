package fr.cvlaminck.alfos.core.name.path

import fr.cvlaminck.alfos.core.name.encoder.DummyNameEncoder
import fr.cvlaminck.alfos.core.name.path.builder.StorageObjectUriBuilder
import fr.cvlaminck.alfos.model.Storage
import fr.cvlaminck.alfos.model.StorageServiceProvider
import fr.cvlaminck.alfos.name.NameEncoder
import fr.cvlaminck.alfos.name.NameValidator

/**
 * An Uri that fully describe the location of an object or a collection.
 *
 * Description of an uri:
 * - Scheme: Every provider supported by this library have an associated scheme. (ex: s3 for Amazon S3)
 * - Domain: Name of the collection.
 * - Path: Name of the object. May not be present if the uri points to a collection.
 *
 * @param providerScheme Scheme associated to the provider that hosts the collection or the object.
 * @param collectionName Name of the collection.
 * @param objectPath Name of the object. May be null if the uri points to a collection.
 * @param nameEncoder
 */
class StorageObjectUri internal constructor(
        val providerScheme: String,
        val collectionName: String,
        val objectPath: StorageObjectPath?,
        val nameValidator: NameValidator,
        val nameEncoder: NameEncoder
) {

    fun buildUpon() = StorageObjectUriBuilder(
            nameValidator,
            nameEncoder,
            providerScheme,
            collectionName,
            objectPath?.buildUpon())

    companion object {
        val SCHEME_SEPARATOR = "://"
    }
}
