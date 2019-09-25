package ar.com.wolox.android.example.ui.graphql

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ar.com.wolox.android.R
import com.apollographql.apollo.FeedQuery

class FeedAdapter : ListAdapter<FeedQuery.FeedEntry, FeedViewHolder>(
        object : DiffUtil.ItemCallback<FeedQuery.FeedEntry>() {
            override fun areItemsTheSame(oldItem: FeedQuery.FeedEntry, newItem: FeedQuery.FeedEntry) = oldItem.id() == newItem.id()

            override fun areContentsTheSame(oldItem: FeedQuery.FeedEntry, newItem: FeedQuery.FeedEntry): Boolean {
                return oldItem == newItem
            }
        }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FeedViewHolder(parent)

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.populate(getItem(position))
    }
}

class FeedViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_feed, parent, false)
) {
    private val title: TextView = itemView.findViewById(R.id.vItemFeedTitle)
    private val subtitle: TextView = itemView.findViewById(R.id.vItemFeedSubTitle)

    fun populate(item: FeedQuery.FeedEntry) {
        if (item.postedBy() != null) {
            title.text = String.format("@%s", item.postedBy()!!.login())
        } else {
            title.text = item.id().toString()
        }

        if (item.repository() != null) {
            subtitle.text = item
                    .repository()?.fragments()?.repositoryFragment()?.full_name()
        } else {
            subtitle.text = itemView.context.getString(R.string.not_repository)
        }
    }
}

/*
*
* class FeedAdapter internal constructor() : RecyclerView.Adapter<FeedAdapter.FeedItemViewHolder>() {

    private val feedEntries: MutableList<FeedQuery.FeedEntry>

    init {
        this.feedEntries = ArrayList()
    }

    internal fun addData(feedEntries: List<FeedQuery.FeedEntry>) {
        this.feedEntries.addAll(feedEntries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedItemViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_feed, parent, false)
        return FeedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedItemViewHolder, position: Int) =
            with(holder.itemView) {

                if (feedEntries[position].postedBy() != null) {
                    lblItem1.text = String.format("@%s", feedEntries[position].postedBy()!!.login())
                } else {
                    lblItem1.text = feedEntries[position].id().toString()
                }

                if (feedEntries[position].repository() != null) {
                    lblItem2.text = feedEntries[position]
                            .repository()?.fragments()?.repositoryFragment()?.full_name()
                } else {
                    lblItem2.text = context.getString(R.string.not_repository)
                }
            }

    override fun getItemCount(): Int = feedEntries.size

    class FeedItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

}
* */