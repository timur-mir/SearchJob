package home.howework.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import home.howework.data.mocknetwork.network.NetworkServiceClient
import home.howework.data.mocknetwork.repository.OffersWorkVacanciesImpl
import home.howework.domain.OffersWorkCompaniesRepository

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun provideNetworkServiceClient(): NetworkServiceClient {
        return NetworkServiceClient()
    }
    @Provides
    fun provideOffersWorkVacanciesImpl():OffersWorkVacanciesImpl {
        return OffersWorkVacanciesImpl(NetworkServiceClient())
    }
}