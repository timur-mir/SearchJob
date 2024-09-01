package home.howework.searchjob.di

import dagger.Component
import home.howework.searchjob.presentation.main.MainViewModelFactory

@Component(
    modules = [
        DataModule::class,
        DomainModule::class,
        PresentationModule::class
    ]
)
interface AppComponent {
    fun mainViewModelFactory(): MainViewModelFactory

}