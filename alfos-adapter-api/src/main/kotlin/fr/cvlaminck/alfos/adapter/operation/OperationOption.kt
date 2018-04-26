package fr.cvlaminck.alfos.adapter.operation

/**
 * Option that can be passed to an operation.
 */
data class OperationOption<T>(
        /**
         * Name of the option.
         */
        val name: String,
        /**
         * Type of the value passed for this option.
         */
        val type: Class<T>,
        /**
         * List of allowed values for the option.
         *
         * null means that all values are allowed.
         */
        val allowedValues: List<T>? = null
) {
    override fun equals(other: Any?): Boolean {
        return if (other == null) false
        else if (!(other is OperationOption<*>)) false
        else name.equals(other.name)
    }

    override fun hashCode(): Int = name.hashCode()
    override fun toString(): String = name
}
