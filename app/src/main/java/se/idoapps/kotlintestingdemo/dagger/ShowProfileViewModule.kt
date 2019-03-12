package se.idoapps.kotlintestingdemo.dagger

import dagger.Module
import dagger.Provides
import se.idoapps.kotlintestingdemo.service.ProfileServiceInterface
import se.idoapps.kotlintestingdemo.viewmodel.ShowProfileViewModel
import se.idoapps.kotlintestingdemo.viewmodel.ShowProfileViewModelInterface
import javax.inject.Singleton

@Module
class ShowProfileViewModule {
    @Provides
    @Singleton
    fun provideShowProfileViewModel(profileService: ProfileServiceInterface): ShowProfileViewModelInterface = ShowProfileViewModel(profileService)
}