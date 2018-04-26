package fr.cvlaminck.alfos.core.operation.result

import fr.cvlaminck.alfos.common.Property
import io.reactivex.Single

internal abstract class ResultMapper<T, ID> {

    abstract fun mapId(properties: Map<Property<in Any>, Any>): ID

    fun mapIdAsSingle(properties: Map<Property<in Any>, Any>): Single<ID>
            = Single.fromCallable { mapId(properties) }

    abstract fun mapProperties(properties: Map<Property<in Any>, Any>): T

    fun mapPropertiesAsSingle(properties: Map<Property<in Any>, Any>): Single<T>
            = Single.fromCallable { mapProperties(properties) }
}
