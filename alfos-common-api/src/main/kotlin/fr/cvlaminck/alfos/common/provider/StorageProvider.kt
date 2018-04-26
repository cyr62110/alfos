package fr.cvlaminck.alfos.common.provider

/**
 * A provider is a solution hosting organized or unorganized data in the form of [Blob].
 * The [Blob] are regrouped into [Bucket].
 *
 * The library allows to access [Blob] from multiple account for a same provider. The
 * association of a provider and an account is a [Storage]. Some providers do not have
 * a notion of account, they will have a single [Storage].
 *
 * This interface does not contains any method relative to operations on [Storage], [Bucket] or
 * [Blob]. Those are defined in the adapter api to ensure better decoupling between public api
 * and implementation details.
 */
interface StorageProvider {

    /**
     * Scheme associated with this provider when using uri to point to a [Bucket] or a [Blob].
     */
    val scheme: String
}
