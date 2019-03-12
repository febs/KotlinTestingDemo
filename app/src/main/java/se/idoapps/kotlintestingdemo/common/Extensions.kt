package se.idoapps.kotlintestingdemo.common

import android.app.Activity
import se.idoapps.kotlintestingdemo.application.TestingDemoApplication

val Activity.app: TestingDemoApplication
    get() = application as TestingDemoApplication