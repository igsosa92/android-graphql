package ar.com.wolox.android.example.di.module

import ar.com.wolox.android.BuildConfig
import ar.com.wolox.wolmo.core.di.scopes.ApplicationScope
import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module
class GraphModule {

    @Provides
    @ApplicationScope
    fun provideApolloClient(okHttpClient: OkHttpClient): ApolloClient =
            ApolloClient.builder()
                    .serverUrl(BuildConfig.BASE_URL)
                    .okHttpClient(okHttpClient)
                    .build()

    @ApplicationScope
    @Provides
    fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()
}