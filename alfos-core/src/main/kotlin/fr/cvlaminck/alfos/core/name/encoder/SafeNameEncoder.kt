package fr.cvlaminck.alfos.core.name.encoder

import fr.cvlaminck.alfos.core.name.SafeNameCharacterRanges
import fr.cvlaminck.alfos.name.NameEncoder

/**
 * Implementation of [NameEncoder] that will follow the strictest rules of provided naming guidelines:
 * - Google Cloud Storage: https://cloud.google.com/storage/docs/naming
 * - Amazon S3 Bucket: http://docs.aws.amazon.com/AmazonS3/latest/dev/BucketRestrictions.html
 * - Amazon S3 Object: http://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html
 *
 * According to the rules , the encoder will do the following things:
 * - replace all unauthorized characters by underscore(_).
 * - collection name will be lower cased, trimmed to 63 characters.
 * - object name will be trimmed to 1024 characters.
 */
class SafeNameEncoder : NameEncoder {

    private val internalNameEncoder: NameEncoder = RangeBasedNameEncoder(
            SafeNameCharacterRanges.COLLECTION_NAME_SAFE_RANGES,
            SafeNameCharacterRanges.PATH_SEGMENT_SAFE_RANGES,
            '-',
            '_'
    )

    override fun encodeCollectionName(collectionName: String): String {
        val encodedCollectionName = internalNameEncoder.encodeCollectionName(collectionName.toLowerCase())
        return if (encodedCollectionName.length > 63) encodedCollectionName.substring(0, 63) else encodedCollectionName
    }

    override fun encodeObjectName(objectName: String): String {
        val encodedObjectName = internalNameEncoder.encodeObjectName(objectName)
        return if (encodedObjectName.length > 1024) encodedObjectName.substring(0, 1024) else encodedObjectName
    }

    override fun encodePathSegmentInObjectName(segment: String): String =
            internalNameEncoder.encodePathSegmentInObjectName(segment)
}
