package com.roy.rromeroarkanochallenge.di

import com.roy.rromeroarkanochallenge.data.remote.datasource.RemoteDataSource
import com.roy.rromeroarkanochallenge.data.remote.datasource.RemoteDataSourceImpl
import com.roy.rromeroarkanochallenge.data.repository.CharacterRepositoryImpl
import com.roy.rromeroarkanochallenge.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(
        impl: RemoteDataSourceImpl
    ): RemoteDataSource

    @Binds
    @Singleton
    abstract fun bindCharacterRepository(
        impl: CharacterRepositoryImpl
    ): CharacterRepository
}