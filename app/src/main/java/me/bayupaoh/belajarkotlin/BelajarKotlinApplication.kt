package me.bayupaoh.belajarkotlin

import android.app.Application
import dagger.Component
import io.realm.Realm
import io.realm.RealmConfiguration
import me.bayupaoh.belajarkotlin.di.component.ApplicationComponent
import me.bayupaoh.belajarkotlin.di.component.DaggerApplicationComponent
import me.bayupaoh.belajarkotlin.presentation.main.MainActivity
import me.bayupaoh.belajarkotlin.di.module.ApplicationModule
import javax.inject.Singleton

/**
 * Created by King Oil on 12/10/2017.
 */
class BelajarKotlinApplication : Application(){
    var injector: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        injector = DaggerApplicationComponent.builder().build()

        Realm.init(this)
        val config = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)
    }}