package com.example.cleancomposeapp.data.di
import android.content.Context
import androidx.room.Room
import com.example.cleancomposeapp.data.local.AppDatabase
import com.example.cleancomposeapp.data.local.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides @Singleton
    fun db(@ApplicationContext c: Context): AppDatabase =
        Room.databaseBuilder(c, AppDatabase::class.java, "app.db").build()

    @Provides fun userDao(db: AppDatabase): UserDao = db.userDao()
}
