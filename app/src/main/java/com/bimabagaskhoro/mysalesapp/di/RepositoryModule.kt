package com.bimabagaskhoro.mysalesapp.di

import com.bimabagaskhoro.mysalesapp.data.source.SalesRepository
import com.bimabagaskhoro.mysalesapp.domain.repository.IItemSalesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideRepository(taskRepository: SalesRepository): IItemSalesRepository
}