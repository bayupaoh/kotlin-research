package me.bayupaoh.belajarkotlin.di.module

import dagger.Module
import dagger.Provides
import me.bayupaoh.belajarkotlin.presentation.main.MainPresenter
import me.bayupaoh.belajarkotlin.domain.network.NewsAPIService
import javax.inject.Singleton

/**
 * Created by King Oil on 12/10/2017.
 */
@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideNewsPresenter(): MainPresenter {
        return MainPresenter()
    }

    @Provides
    @Singleton
    fun provideNewApiInterface(): NewsAPIService {
        return NewsAPIService.Factory.create()
    }
}