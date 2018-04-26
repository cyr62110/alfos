package fr.cvlaminck.alfos.api.exception

import fr.cvlaminck.alfos.common.storage.StorageId

class MissingStorageException(
        storageId: StorageId
) : AlfosApiException("No storage actually registered for id '${storageId}'.")
