package home.howework.searchjob.di

import dagger.Module
import dagger.Provides
import home.howework.searchjob.data.mocknetwork.repository.OffersWorkVacanciesImpl
import home.howework.searchjob.domain.GetOffersWorkCompaniesUseCase

@Module
class DomainModule {
@Provides
fun provideGetOffersWorkCompaniesImpl(offersWorkVacanciesImpl: OffersWorkVacanciesImpl):GetOffersWorkCompaniesUseCase{
    return GetOffersWorkCompaniesUseCase(offersWorkVacanciesImpl)
}
}