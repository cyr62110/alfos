package fr.cvlaminck.alfos.core.name.encoder

import fr.cvlaminck.alfos.name.NameEncoder

/**
 * Implementation of [NameEncoder] that does not modify the input.
 */
class DummyNameEncoder : NameEncoder {

    override fun encodeObjectName(objectName: String): String = objectName

    override fun encodePathSegmentInObjectName(segment: String): String = segment

    override fun encodeCollectionName(collectionName: String): String = collectionName
}
