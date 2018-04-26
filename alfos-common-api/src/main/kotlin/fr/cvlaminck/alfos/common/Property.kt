package fr.cvlaminck.alfos.common

/**
 * A property is a metadata attached to an object (storage, bucket or blob).
 *
 * The name of a property is unique and specific to a given object type.
 * For ex. the name of the id property is different for a blob (blob.id)
 * than for a bucket (bucket.id).
 */
data class Property<T> (
        /**
         * Name of the property.
         */
        val name: String,
        /**
         * Type of the property.
         */
        val type: Class<T>,
        /**
         * Whether or not the property can be edited using the library.
         */
        val readOnly: Boolean = false,
        /**
         * List of allowed values.
         */
        val allowedValues: List<Any>? = null
)
