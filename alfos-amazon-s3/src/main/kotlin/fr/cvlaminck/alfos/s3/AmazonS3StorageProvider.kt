package fr.cvlaminck.alfos.s3

import fr.cvlaminck.alfos.model.StorageServiceProvider
import fr.cvlaminck.alfos.name.NameValidator

object AmazonS3StorageProvider : StorageServiceProvider {

    override val name: String
        get() = "Amazon S3"

    override val scheme: String
        get() = TODO("not implemented")

    override val nameValidator: NameValidator
        get() = TODO("not implemented")
}
