package com.bosta.bostatask.di

import com.bosta.bostatask.data.repository.UserRepositoryImpl
import com.bosta.bostatask.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindUserRepository( repositoryImpl: UserRepositoryImpl) : UserRepository
}