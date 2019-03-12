package se.idoapps.kotlintestingdemo.dagger

import dagger.Module
import dagger.Provides
import se.idoapps.kotlintestingdemo.repository.ProfileRepositoryInterface
import se.idoapps.kotlintestingdemo.service.ProfileService
import se.idoapps.kotlintestingdemo.service.ProfileServiceInterface
import javax.inject.Singleton

@Module
class ProfileServiceModule {
    @Provides
    @Singleton
    fun provideProfileService(profileRepository: ProfileRepositoryInterface): ProfileServiceInterface = ProfileService(profileRepository)
}