package ar.com.wolox.android.example.ui.graphql

import android.os.Handler
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.FeedQuery
import com.apollographql.apollo.ApolloQueryCall
import com.apollographql.apollo.ApolloCallback
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.apollographql.apollo.fetcher.ApolloResponseFetchers
import com.apollographql.apollo.type.FeedType
import javax.inject.Inject

class FeedInteractor @Inject constructor(private val apolloClient: ApolloClient, private val handler: Handler) : FeedContract.Interactor {

    private var dataApolloCall: ApolloCall<FeedQuery.Data>? = null

    override fun getFeedFromApollo(limit: Int, callback: FeedContract.Callback) {

        val feedQuery = FeedQuery.builder()
                .limit(limit)
                .type(FeedType.HOT)
                .build()

        dataApolloCall = apolloClient
                .query(feedQuery)
                .responseFetcher(ApolloResponseFetchers.NETWORK_FIRST)

        (dataApolloCall as ApolloQueryCall<FeedQuery.Data>)
                .enqueue(ApolloCallback(object : ApolloCall.Callback<FeedQuery.Data>() {
                    override fun onResponse(response: Response<FeedQuery.Data>) {
                        callback.getFeedSuccess(
                                response.data()!!.feedEntries() as List<FeedQuery.FeedEntry>)
                    }

                    override fun onFailure(e: ApolloException) {
                        callback.getFeedError(e.message.toString())
                    }
                }, handler))
    }

    override fun cancelCalls() {
        if (dataApolloCall != null) {
            dataApolloCall!!.cancel()
        }
    }
}