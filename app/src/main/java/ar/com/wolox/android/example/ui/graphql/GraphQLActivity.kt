package ar.com.wolox.android.example.ui.graphql

import android.content.Context
import android.content.Intent
import ar.com.wolox.android.R
import ar.com.wolox.android.example.utils.toggleVisibility
import ar.com.wolox.wolmo.core.activity.WolmoActivity
import ar.com.wolox.wolmo.core.util.ToastFactory
import com.apollographql.apollo.FeedQuery
import kotlinx.android.synthetic.main.graphql_fragment.*
import javax.inject.Inject

class GraphQLActivity @Inject constructor() : WolmoActivity(), GraphQLView {

    @Inject
    lateinit var toastFactory: ToastFactory

//    override fun init() = replaceFragment(R.id.vActivityBaseContent, GraphQLFragment.newInstance())
    override fun init() {}

    override fun layout() = R.layout.activity_base

    override fun showLoading() {
        vGraphQLProgressBar.toggleVisibility(true)
    }

    override fun hideLoading() {
        vGraphQLProgressBar.toggleVisibility(false)
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