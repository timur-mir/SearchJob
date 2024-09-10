package home.howework.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import home.howework.data.mocknetwork.repository.OffersWorkVacanciesImpl
import home.howework.domain.GetOffersWorkCompaniesUseCase
import home.howework.domain.OffersWorkCompaniesRepository

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    fun provideGetOffersWorkCompaniesUseCase(offersWorkCompaniesRepository: OffersWorkVacanciesImpl): GetOffersWorkCompaniesUseCase {
        return GetOffersWorkCompaniesUseCase(offersWorkCompaniesRepository)
    }
}