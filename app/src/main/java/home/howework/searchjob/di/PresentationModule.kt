package home.howework.searchjob.di

import dagger.Module
import dagger.Provides
import home.howework.searchjob.data.mocknetwork.repository.OffersWorkVacanciesImpl
import home.howework.searchjob.domain.GetOffersWorkCompaniesUseCase
import home.howework.searchjob.domain.OffersWorkCompaniesRepository
import home.howework.searchjob.presentation.main.MainViewModel
import home.howework.searchjob.presentation.main.MainViewModelFactory

@Module
class PresentationModule {
    @Provides
    fun provideMainViewModel(repository: OffersWorkVacanciesImpl,useCase:GetOffersWorkCompaniesUseCase):MainViewModel{
        return MainViewModel(repository,useCase)
    }
    @Provides
    fun provideMinViewModelFactory(mainViewModel:MainViewModel): MainViewModelFactory {
        return MainViewModelFactory(mainViewModel)
    }
}