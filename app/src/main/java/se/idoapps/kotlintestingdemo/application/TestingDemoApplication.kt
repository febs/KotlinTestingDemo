package se.idoapps.kotlintestingdemo.application

import android.app.Application
import se.idoapps.kotlintestingdemo.dagger.AppComponent
import se.idoapps.kotlintestingdemo.dagger.AppModule
import se.idoapps.kotlintestingdemo.dagger.DaggerAppComponent

class TestingDemoApplication: Application() {
    lateinit var appComponent: AppComponent

    init {
        instance = this
    }

    companion object {
        private var instance: TestingDemoApplication? = null

        val application: TestingDemoApplication
            get() = instance!!
    }

    override fun onCreate() {
        super.onCreate()

        initDagger(this)
    }

    private fun initDagger(app: TestingDemoApplication) {
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(app))
            .build()

        appComponent.inject(this)
    }
}