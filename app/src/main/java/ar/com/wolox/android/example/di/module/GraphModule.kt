package ar.com.wolox.android.example.di.module

import ar.com.wolox.android.BuildConfig
import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class GraphModule {

    @Provides
    @Singleton
    fun provideApolloClient(okHttpClient: OkHttpClient): ApolloClient =
            ApolloClient.builder()
                    .serverUrl(BuildConfig.BASE_URL)
                    .okHttpClient(okHttpClient)
                    .build()
}