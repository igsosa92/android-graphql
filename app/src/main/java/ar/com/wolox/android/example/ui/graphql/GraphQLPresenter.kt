package ar.com.wolox.android.example.ui.graphql

import ar.com.wolox.wolmo.core.presenter.BasePresenter
import com.apollographql.apollo.FeedQuery
import javax.inject.Inject

class GraphQLPresenter @Inject constructor(
    private val interactor: FeedInteractor
) : BasePresenter<GraphQLView>(), FeedContract.Callback {

    private var showLoading : Boolean? = null
        set(value) {
            field = value
            value?.let { view.showLoading(it) }
        }

    fun getFeed(limit: Int) {
        showLoading = true
        interactor.getFeedFromApollo(limit, this)
    }

    override fun getFeedSuccess(feedEntries: List<FeedQuery.FeedEntry>) {
        showLoading = false
        view.showResult(feedEntries)
    }

    override fun getFeedError(error: String) {
        showLoading = false
        view.showError(error)
    }

    fun onViewDestroyed() {
        interactor.cancelCalls()
    }
}