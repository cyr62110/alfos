package fr.cvlaminck.alfos.core.operation.option

import fr.cvlaminck.alfos.adapter.operation.OperationOptions
import io.reactivex.Single

internal abstract class OptionsMapper<T> {

    abstract fun map(options: T): OperationOptions

    fun mapAsSingle(options: T): Single<OperationOptions>
        = Single.fromCallable { map(options) }
}
