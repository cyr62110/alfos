package fr.cvlaminck.alfos.core.operation.option.storage

import fr.cvlaminck.alfos.adapter.operation.OperationOptions
import fr.cvlaminck.alfos.adapter.operation.storage.ListBucketsOperationOptions
import fr.cvlaminck.alfos.api.storage.ListBucketsOptions
import fr.cvlaminck.alfos.core.operation.option.DefaultOperationOptions
import fr.cvlaminck.alfos.core.operation.option.OptionsMapper

internal class ListBucketOptionsMapper : OptionsMapper<ListBucketsOptions>() {

    override fun map(options: ListBucketsOptions): OperationOptions {
        val opts = DefaultOperationOptions()
        if (options.prefix != null) {
            opts.set(ListBucketsOperationOptions.PREFIX, options.prefix)
        }
        return opts
    }
}
