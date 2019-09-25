package ar.com.wolox.android.example.di

import ar.com.wolox.android.example.ui.example.ExampleActivity
import ar.com.wolox.android.example.ui.example.ExampleFragment
import ar.com.wolox.android.example.ui.graphql.FeedModule
import ar.com.wolox.android.example.ui.graphql.GraphQLActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector
    internal abstract fun exampleActivity(): ExampleActivity

    @ContributesAndroidInjector
    internal abstract fun exampleFragment(): ExampleFragment

//    @ContributesAndroidInjector
//    internal abstract fun contributesGraphQLFragment(): GraphQLFragment

    @ContributesAndroidInjector(modules = [(FeedModule::class)])
    internal abstract fun contributesGraphQLActivity(): GraphQLActivity
}
