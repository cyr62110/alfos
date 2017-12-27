package fr.cvlaminck.alfos.gcs

import fr.cvlaminck.alfos.model.StorageServiceProvider
import fr.cvlaminck.alfos.name.NameValidator

object GoogleProvider : StorageServiceProvider {

    override val name: String = "Google cloud storage"

    override val scheme: String = "gcs"

    override val nameValidator: NameValidator
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}
