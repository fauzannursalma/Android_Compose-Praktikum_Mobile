package com.unpas.tif.prakmobile.fauzann.setoransampah.di

import android.app.Application
import androidx.room.Room
import com.unpas.tif.prakmobile.fauzann.setoransampah.persistences.AppDatabase
import com.unpas.tif.prakmobile.fauzann.setoransampah.persistences.SetoranSampahDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(
                application,
                AppDatabase::class.java,
                "pengelolaan-sampah"
            )
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideSetoranSampahDao(appDatabase: AppDatabase): SetoranSampahDao {
        return appDatabase.setoranSampahDao()
    }
}