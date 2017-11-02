package fr.cvlaminck.alfos.core

import fr.cvlaminck.alfos.model.Storage

class StorageRegistry {

    private val storages: MutableSet<Storage> = hashSetOf()

    fun registerStorage(storage: Storage) = synchronized(this) {
        storages.add(storage)
    }
}
