package se.idoapps.kotlintestingdemo.dagger

import dagger.Component
import se.idoapps.kotlintestingdemo.application.TestingDemoApplication
import se.idoapps.kotlintestingdemo.view.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ProfileRepositoryModule::class,
    ProfileServiceModule::class,
    ShowProfileViewModule::class])

interface AppComponent {
    fun inject(target: TestingDemoApplication)
    fun inject(target: MainActivity)
}