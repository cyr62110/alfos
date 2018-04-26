package fr.cvlaminck.alfos.adapter.bucket

import fr.cvlaminck.alfos.common.Property

/**
 * List of all properties that are possibly available for a bucket.
 *
 * Providers are not expected to provide all properties for a given bucket.
 */
object BucketProperties {
    val ID = Property("bucket.id", String::class.java)
    val OWNER_NAME = Property("bucket.owner.name", String::class.java)
    val OWNER_ID = Property("bucket.owner.id", String::class.java)
}
