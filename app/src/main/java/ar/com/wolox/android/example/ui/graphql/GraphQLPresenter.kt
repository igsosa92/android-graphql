package ar.com.wolox.android.example.ui.graphql

import ar.com.wolox.wolmo.core.presenter.BasePresenter
import com.apollographql.apollo.FeedQuery
import javax.inject.Inject

class GraphQLPresenter @Inject constructor(
    private val interactor: FeedInteractor
) : BasePresenter<GraphQLView>(), FeedContract.Callback {

    fun getFeed(limit: Int) {
        view.showLoading()
        interactor.getFeedFromApollo(limit, this)
    }

    override fun getFeedSuccess(feedEntries: List<FeedQuery.FeedEntry>) {
        view.hideLoading()
        view.showResult(feedEntries)
    }

    override fun getFeedError(error: String) {
        view.hideLoading()
        view.showError(error)
    }

    fun onViewDestroyed() {
        interactor.cancelCalls()
    }
}