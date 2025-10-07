package com.example.cleancomposeapp.data.di
import com.example.cleancomposeapp.data.repository.UserRepositoryImpl
import com.example.cleancomposeapp.data.remote.UserApi
import com.example.cleancomposeapp.data.local.UserDao
import com.example.cleancomposeapp.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides @Singleton
    fun userRepository(api: UserApi, dao: UserDao): UserRepository =
        UserRepositoryImpl(api, dao)
}
