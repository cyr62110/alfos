package fr.cvlaminck.alfos.core.operation.option

import fr.cvlaminck.alfos.adapter.operation.OperationOptions
import fr.cvlaminck.alfos.adapter.operation.OperationOption

class DefaultOperationOptions : OperationOptions {

    private val optionValues = mutableMapOf<OperationOption<out Any>, Any?>()

    override val operationOptions: Collection<OperationOption<out Any>>
        get() = optionValues.keys

    fun <T : Any> set(operationOption: OperationOption<T>, value: T?) {
        optionValues[operationOption] = value
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : Any> get(operationOption: OperationOption<T>): T? = optionValues.get(operationOption) as T?
}
