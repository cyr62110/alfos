package fr.cvlaminck.alfos.gcs.publisher

import com.google.api.gax.paging.Page
import com.google.cloud.storage.Bucket
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.jupiter.api.Test
import org.reactivestreams.Subscriber

internal class PagePublisherTest {

    @Test
    fun subscribe() {
        val page = mock<Page<Bucket>>()
        val subscriber = mock<Subscriber<Bucket>>()

        PagePublisher { page }
                .subscribe(subscriber)

        verify(subscriber).onSubscribe(any<PageSubscription<Bucket>>())
    }
}
