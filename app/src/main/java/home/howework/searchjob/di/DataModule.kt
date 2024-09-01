package home.howework.searchjob.di

import dagger.Module
import dagger.Provides
import home.howework.searchjob.data.mocknetwork.repository.NetworkServiceClient
import home.howework.searchjob.data.mocknetwork.repository.OffersWorkVacanciesImpl

@Module
class DataModule {
    @Provides
    fun provideNetworkServiceClient():NetworkServiceClient{
        return NetworkServiceClient()
    }
    @Provides
    fun provideOffersWorkVacanciesImpl(): OffersWorkVacanciesImpl{
        return OffersWorkVacanciesImpl()
    }

}