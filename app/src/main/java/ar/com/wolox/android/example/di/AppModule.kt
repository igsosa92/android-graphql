package ar.com.wolox.android.example.di

import ar.com.wolox.android.example.ui.graphql.FeedModule
import ar.com.wolox.android.example.ui.graphql.GraphQLActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector(modules = [(FeedModule::class)])
    internal abstract fun contributesGraphQLActivity(): GraphQLActivity
}
