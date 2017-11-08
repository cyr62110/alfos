package fr.cvlaminck.alfos.core.name.encoder

import fr.cvlaminck.alfos.name.NameEncoder

/**
 * Implementation of [NameEncoder] that will follow the strictest rules of provided naming guidelines:
 * - Google Cloud Storage: https://cloud.google.com/storage/docs/naming
 * - Amazon S3 Bucket: http://docs.aws.amazon.com/AmazonS3/latest/dev/BucketRestrictions.html
 * - Amazon S3 Object: http://docs.aws.amazon.com/AmazonS3/latest/dev/UsingMetadata.html
 *
 * This encoder will replace all unauthorized characters by underscore(_).
 */
class SafeNameEncoder : NameEncoder {

    override fun encodeObjectName(objectName: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun encodePathSegmentInObjectName(segment: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun encodeCollectionName(collectionName: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
