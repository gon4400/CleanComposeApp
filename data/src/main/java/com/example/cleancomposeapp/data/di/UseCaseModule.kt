package com.example.cleancomposeapp.data.di

import com.example.cleancomposeapp.domain.repository.UserRepository
import com.example.cleancomposeapp.domain.usecase.GetUserUseCase
import com.example.cleancomposeapp.domain.usecase.ObserveUsersUseCase
import com.example.cleancomposeapp.domain.usecase.RefreshUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides @Singleton
    fun provideObserveUsersUseCase(repo: UserRepository): ObserveUsersUseCase =
        ObserveUsersUseCase(repo)

    @Provides @Singleton
    fun provideRefreshUsersUseCase(repo: UserRepository): RefreshUsersUseCase =
        RefreshUsersUseCase(repo)

    @Provides @Singleton
    fun provideGetUserUseCase(repo: UserRepository): GetUserUseCase =
        GetUserUseCase(repo)
}
