package ar.com.wolox.android.example.ui.graphql

import android.content.Context
import android.content.Intent
import ar.com.wolox.android.R
import ar.com.wolox.android.example.utils.toggleVisibility
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import ar.com.wolox.wolmo.core.util.ToastFactory
import com.apollographql.apollo.FeedQuery
import kotlinx.android.synthetic.main.activity_base.*
import javax.inject.Inject

class GraphQLActivity @Inject constructor() : WolmoActivity(), GraphQLView {

    @Inject
    lateinit var toastFactory: ToastFactory

    override fun init() {}

    override fun layout() = R.layout.activity_base

    override fun showLoading(state: Boolean) {
        vGraphQLProgressBar.toggleVisibility(state)
    }

    override fun showError(error: String) {
        toastFactory.show(error)
    }

    override fun showResult(feedEntries: List<FeedQuery.FeedEntry>) {}

    companion object {

        fun start(context: Context) {
            context.startActivity(Intent(context, GraphQLActivity::class.java))
        }
    }
}