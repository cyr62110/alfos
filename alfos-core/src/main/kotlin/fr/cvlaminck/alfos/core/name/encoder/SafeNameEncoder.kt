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
}
