package se.idoapps.kotlintestingdemo.dagger

import dagger.Module
import dagger.Provides
import se.idoapps.kotlintestingdemo.repository.ProfileRepository
import se.idoapps.kotlintestingdemo.repository.ProfileRepositoryInterface
import javax.inject.Singleton

@Module
class ProfileRepositoryModule {
    @Provides
    @Singleton
    fun provideProfileRepository(): ProfileRepositoryInterface = ProfileRepository()
}