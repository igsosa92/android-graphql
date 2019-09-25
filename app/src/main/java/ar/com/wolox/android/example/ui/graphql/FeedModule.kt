package ar.com.wolox.android.example.ui.graphql

import android.os.Handler
import android.os.Looper
import com.apollographql.apollo.ApolloClient
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class FeedModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideMainHandler() = Handler(Looper.getMainLooper())

        @Provides
        @JvmStatic
        fun provideFeedInteractor(
            apolloClient: ApolloClient,
            handler: Handler
        ) = FeedInteractor(apolloClient, handler)

        @Provides
        @JvmStatic
        fun provideFeedPresenter(
            interactor: FeedInteractor
        ) = GraphQLPresenter(interactor)
    }

    @Binds
    abstract fun provideFeedView(mainActivity: GraphQLActivity): GraphQLView
}