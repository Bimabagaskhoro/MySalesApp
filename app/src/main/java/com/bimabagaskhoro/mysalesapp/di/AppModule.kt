package com.bimabagaskhoro.mysalesapp.di

import com.bimabagaskhoro.mysalesapp.domain.usecase.ItemSalesInteractor
import com.bimabagaskhoro.mysalesapp.domain.usecase.ItemSalesUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun provideTaskUseCase(itemSalesInteractor: ItemSalesInteractor): ItemSalesUseCase
}