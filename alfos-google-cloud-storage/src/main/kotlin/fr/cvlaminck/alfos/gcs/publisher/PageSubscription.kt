package fr.cvlaminck.alfos.gcs.publisher

import com.google.api.gax.paging.Page
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

internal class PageSubscription<in T>(
        private val subscriber: Subscriber<in T>,
        page: Page<T>
) : Subscription {

    private var currentPage: Page<T>? = page
    private var currentIterator: Iterator<T>? = page.values.iterator()

    override fun request(n: Long) {
        if (currentPage == null) {
            subscriber.onError(IllegalStateException("Reading element from already closed page."))
            return
        }

        try {
            var nbElt = 0
            while (currentPage != null && nbElt < n) {
                val currentIterator = this.currentIterator!!
                if (currentIterator.hasNext()) {
                    val value = currentIterator.next()
                    subscriber.onNext(value)
                    nbElt++
                } else {
                    moveToNextPage()
                }
            }

            if (nbElt < n) {
                subscriber.onComplete()
                cancel()
            }
        } catch (t: Throwable) {
            subscriber.onError(t)
            cancel()
        }
    }

    internal fun moveToNextPage() {
        val currentPage = this.currentPage ?: throw IllegalStateException("Moving to next page from already closed page.")
        if (currentPage.hasNextPage()) {
            val nextPage = currentPage.nextPage
            this.currentPage = nextPage
            this.currentIterator = nextPage.values.iterator()
        } else {
            cancel()
        }
    }

    override fun cancel() {
        currentPage = null
        currentIterator = null
    }
}
