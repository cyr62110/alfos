package fr.cvlaminck.alfos.exception

class UnknownProviderException private constructor(
        message: String
) : AlfosRuntimeException(message) {

    companion object {

        fun createWithName(name: String): UnknownProviderException =
                UnknownProviderException("No provider with name '${name}' has been registered.")

        fun createWithScheme(scheme: String): UnknownProviderException =
                UnknownProviderException("No provider with scheme '${scheme}' has been registered.")
    }
}
