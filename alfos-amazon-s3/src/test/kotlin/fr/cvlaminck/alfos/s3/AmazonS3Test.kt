package fr.cvlaminck.alfos.s3

import com.amazonaws.services.s3.AmazonS3ClientBuilder

open class AmazonS3Test {

    val client by lazy {
        AmazonS3ClientBuilder.defaultClient()
    }

    val storage by lazy {
        AmazonS3Storage(client)
    }
}
