package fr.cvlaminck.alfos.adapter.operation.storage

import fr.cvlaminck.alfos.adapter.operation.OperationOption

object ListBucketsOperationOptions {
    val PREFIX = OperationOption("bucket.list.prefix", String::class.java)
}
