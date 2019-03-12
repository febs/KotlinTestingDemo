package se.idoapps.kotlintestingdemo

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import se.idoapps.kotlintestingdemo.model.GenderTypes
import se.idoapps.kotlintestingdemo.model.PhysicalActivityTypes
import se.idoapps.kotlintestingdemo.model.Profile
import java.time.LocalDateTime

class TestProfileCalculations {
    private lateinit var maleProfile: Profile
    private lateinit var femaleProfile: Profile

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

    @Test
    fun testCalculateDailyCarbIntakeMale() {
        // ARRANGE

        // ACT
        val result = maleProfile.calculateDailyCarbIntake()

        // ASSERT
        assertEquals(531, result)
    }

    @Test
    fun testCalculateDailyCarbIntakeFemale() {
        // ARRANGE

        // ACT
        val result = femaleProfile.calculateDailyCarbIntake()

        // ASSERT
        assertEquals(289, result)
    }

    @Test
    fun testCalculateDailyProteinIntakeMale() {
        // ARRANGE

        // ACT
        val result = maleProfile.calculateDailyProteinIntake()

        // ASSERT
        assertEquals(163, result)
    }

    @Test
    fun testCalculateDailyProteinIntakeFemale() {
        // ARRANGE

        // ACT
        val result = femaleProfile.calculateDailyProteinIntake()

        // ASSERT
        assertEquals(89, result)
    }

    @Test
    fun testCalculateDailyFatIntakeMale() {
        // ARRANGE

        // ACT
        val result = maleProfile.calculateDailyFatIntake()

        // ASSERT
        assertEquals(121, result)
    }

    @Test
    fun testCalculateDailyFatIntakeFemale() {
        // ARRANGE

        // ACT
        val result = femaleProfile.calculateDailyFatIntake()

        // ASSERT
        assertEquals(66, result)
    }
}
