package com.unpas.tif.prakmobile.fauzann.setoransampah.di

import com.unpas.tif.prakmobile.fauzann.setoransampah.networks.SetoranSampahApi
import com.unpas.tif.prakmobile.fauzann.setoransampah.persistences.SetoranSampahDao
import com.unpas.tif.prakmobile.fauzann.setoransampah.repositories.SetoranSampahRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideSetoranSampahRepository(
        api: SetoranSampahApi,
        dao: SetoranSampahDao
    ): SetoranSampahRepository {
        return SetoranSampahRepository(api, dao)
    }
}