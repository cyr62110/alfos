package fr.cvlaminck.alfos.gcs.publisher

import com.google.api.gax.paging.Page
import org.reactivestreams.Publisher
import org.reactivestreams.Subscriber

internal class PagePublisher<T>(
        private val pageFactoryMethod: () -> Page<T>
) : Publisher<T> {

    override fun subscribe(subscriber: Subscriber<in T>) {
        try {
            val page = pageFactoryMethod()
            subscriber.onSubscribe(PageSubscription(subscriber, page))
        } catch (t: Throwable) {
            subscriber.onError(t)
        }
    }
}
