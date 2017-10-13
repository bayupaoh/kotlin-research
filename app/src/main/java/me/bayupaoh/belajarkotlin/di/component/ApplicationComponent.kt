package me.bayupaoh.belajarkotlin.di.component

import dagger.Component
import me.bayupaoh.belajarkotlin.di.module.ApplicationModule
import me.bayupaoh.belajarkotlin.presentation.main.MainActivity
import javax.inject.Singleton

/**
 * Created by King Oil on 13/10/2017.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(activity: MainActivity)

}
