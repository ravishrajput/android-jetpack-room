package com.ravish.android.jetpack.room.di

import com.ravish.android.jetpack.room.DBUseCaseImpl
import com.ravish.android.jetpack.room.db.AppDatabase
import com.ravish.android.jetpack.room.db.DBUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DBUseCaseModule {

    @Provides
    @Singleton
    fun provideDBUseCase(appDatabase: AppDatabase): DBUseCase = DBUseCaseImpl(appDatabase)
}