package com.bimabagaskhoro.mysalesapp.di

import android.content.Context
import com.bimabagaskhoro.mysalesapp.sf.AppSharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SharedPrefModule {
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context) = AppSharedPreferences(context)
}