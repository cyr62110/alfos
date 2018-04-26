package fr.cvlaminck.alfos.adapter.operation

/**
 * Collection of options that are passed to an operation.
 */
interface OperationOptions {

    /**
     * Collection of options that have a value associated to them.
     */
    val operationOptions: Collection<OperationOption<out Any>>

    /**
     * Returns the value associated with the option.
     */
    fun <T : Any> get(operationOption: OperationOption<T>): T?
}
