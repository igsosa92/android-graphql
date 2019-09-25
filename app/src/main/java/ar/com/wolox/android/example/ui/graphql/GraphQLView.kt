package ar.com.wolox.android.example.ui.graphql

import com.apollographql.apollo.FeedQuery
import kotlinx.android.synthetic.main.graphql_fragment.*

// class GraphQLFragment @Inject constructor() : WolmoFragment<GraphQLPresenter>(), GraphQLView {
//
//    @Inject
//    lateinit var toastFactory: ToastFactory
//
//    override fun init() {
//
//        // Move this to onViewAttach
//        presenter.getFeed(10)
//    }
//
//    override fun layout() = R.layout.graphql_fragment
//
//    // Change the way the progressBar is controlled by the presenter with a customSetter
//    override fun showLoading() {
//        vGraphQLProgressBar.toggleVisibility(true)
//    }
//
//    override fun hideLoading() {
//        vGraphQLProgressBar.toggleVisibility(false)
//    }
//
//    override fun showError(error: String) {
//        toastFactory.show(error)
//    }
//
//    // override fun showResult(feedEntries: List<FeedQuery.FeedEntry>) {}
//
//    override fun onDestroy() {
//        super.onDestroy()
//        presenter.onViewDestroyed()
//    }
//
//    companion object {
//
//        fun newInstance() = GraphQLFragment()
//    }
// }

interface GraphQLView {

    fun showLoading()

    fun hideLoading()

    fun showError(error: String)

    fun showResult(feedEntries: List<FeedQuery.FeedEntry>)
}