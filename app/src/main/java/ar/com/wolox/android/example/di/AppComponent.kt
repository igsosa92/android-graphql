package ar.com.wolox.android.example.di

import android.app.Application

import ar.com.wolox.android.example.GraphQLExampleApp
import ar.com.wolox.android.example.di.module.GraphModule
import ar.com.wolox.android.example.di.module.MiscModule
import ar.com.wolox.wolmo.core.di.modules.ContextModule
import ar.com.wolox.wolmo.core.di.modules.DefaultModule
import ar.com.wolox.wolmo.core.di.scopes.ApplicationScope
import ar.com.wolox.wolmo.networking.di.NetworkingComponent

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScope
@Component(dependencies = [NetworkingComponent::class],
        modules = [AndroidSupportInjectionModule::class, DefaultModule::class, ContextModule::class,
            AppModule::class, MiscModule::class, GraphModule::class])
interface AppComponent : AndroidInjector<GraphQLExampleApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<GraphQLExampleApp>() {

        @BindsInstance
        abstract fun application(application: Application): Builder

        @BindsInstance
        abstract fun sharedPreferencesName(sharedPrefName: String): Builder

        abstract fun networkingComponent(networkingComponent: NetworkingComponent): Builder
    }
}
