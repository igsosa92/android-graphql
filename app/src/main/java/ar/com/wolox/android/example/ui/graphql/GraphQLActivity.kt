package ar.com.wolox.android.example.ui.graphql

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import ar.com.wolox.android.R
import ar.com.wolox.android.example.utils.togglePresence
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import ar.com.wolox.wolmo.core.util.ToastFactory
import com.apollographql.apollo.FeedQuery
import kotlinx.android.synthetic.main.activity_base.*
import javax.inject.Inject

class GraphQLActivity @Inject constructor() : WolmoActivity(), GraphQLView {

    @Inject
    lateinit var toastFactory: ToastFactory

    @Inject
    lateinit var presenter: GraphQLPresenter

    private val feedAdapter: FeedAdapter by lazy { FeedAdapter() }

    override fun init() {
        val layoutManager = LinearLayoutManager(applicationContext)
        vGraphQLRecycler.apply {
            this.layoutManager = layoutManager
            adapter = feedAdapter
        }
        presenter.getFeed(10)
    }

    override fun layout() = R.layout.activity_base

    override fun showLoading(state: Boolean) {
        vGraphQLProgressBar.togglePresence(state)
    }

    override fun showError(error: String) {
        toastFactory.show(error)
    }

    override fun showResult(feedEntries: List<FeedQuery.FeedEntry>) {
        feedAdapter.submitList(feedEntries)
    }

    companion object {

        fun start(context: Context) {
            context.startActivity(Intent(context, GraphQLActivity::class.java))
        }
    }
}