package fr.cvlaminck.alfos.core.operation.result.bucket

import fr.cvlaminck.alfos.api.bucket.BucketProperties
import fr.cvlaminck.alfos.common.Property
import fr.cvlaminck.alfos.common.bucket.BucketId
import fr.cvlaminck.alfos.core.operation.result.ResultMapper

internal class BucketResultMapper : ResultMapper<BucketProperties, BucketId>() {

    override fun mapId(properties: Map<Property<in Any>, Any>): BucketId {
        val id: String = properties.get(fr.cvlaminck.alfos.adapter.bucket.BucketProperties.ID)
    }

    override fun mapProperties(properties: Map<Property<in Any>, Any>): BucketProperties {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
