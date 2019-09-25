package ar.com.wolox.android.example.ui.graphql

import com.apollographql.apollo.FeedQuery

interface FeedContract {

    interface Interactor {

        fun getFeedFromApollo(limit: Int, callback: Callback)

        fun cancelCalls()
    }

    interface Callback {

        fun getFeedSuccess(feedEntries: List<FeedQuery.FeedEntry>)

        fun getFeedError(error: String)
    }
}