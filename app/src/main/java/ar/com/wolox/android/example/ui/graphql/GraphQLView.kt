package ar.com.wolox.android.example.ui.graphql

import com.apollographql.apollo.FeedQuery

interface GraphQLView {

    fun showLoading(state: Boolean)

    fun showError(error: String)

    fun showResult(feedEntries: List<FeedQuery.FeedEntry>)
}