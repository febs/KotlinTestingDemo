package se.idoapps.kotlintestingdemo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule
import se.idoapps.kotlintestingdemo.model.GenderTypes
import se.idoapps.kotlintestingdemo.model.PhysicalActivityTypes
import se.idoapps.kotlintestingdemo.model.Profile
import java.time.LocalDateTime

class TestProfileCalculations {
    private lateinit var maleProfile: Profile
    private lateinit var femaleProfile: Profile

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun initTests() {
        maleProfile = Profile()
        maleProfile.birthDate = LocalDateTime.now().minusYears(47)
        maleProfile.gender = GenderTypes.Male
        maleProfile.weight = 105
        maleProfile.height = 183
        maleProfile.physicalActivity = PhysicalActivityTypes.Moderate

        femaleProfile = Profile()
        femaleProfile.birthDate = LocalDateTime.now().minusYears(42)
        femaleProfile.gender = GenderTypes.Female
        femaleProfile.weight = 55
        femaleProfile.height = 168
        femaleProfile.physicalActivity = PhysicalActivityTypes.SlightlyActive
    }

    @Test
    fun testCalculateDailyEnergyIntakeMale() {
        // ARRANGE

        // ACT
        val result = Math.round(maleProfile.calculateDailyEnergyIntake()).toInt()

        // ASSERT
        assertEquals(3268, result)
    }

    @Test
    fun testCalculateDailyEnergyIntakeFemale() {
        // ARRANGE

        // ACT
        val result = Math.round(femaleProfile.calculateDailyEnergyIntake()).toInt()

        // ASSERT
        assertEquals(1781, result)
    }
}
