package fr.cvlaminck.alfos.example.storage

import fr.cvlaminck.alfos.adapter.fs.FileStorageProviderAdapter
import fr.cvlaminck.alfos.core.DefaultStorageManager
import fr.cvlaminck.alfos.core.DefaultStorageRegistry
import java.nio.file.Paths

class ListBucketsExample {

    fun displayBuckets() {
        val baseStoragePath = Paths.get(".")

        val storageRegistry = DefaultStorageRegistry()
        val storageManager = DefaultStorageManager(storageRegistry)

        val storageId = storageRegistry.registerStorage(FileStorageProviderAdapter(baseStoragePath))

        storageManager.getStorage(storageId)
                .flatMapPublisher { it.listBuckets() }
                .subscribe(System.out::println)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ListBucketsExample().displayBuckets()
        }
    }
}
