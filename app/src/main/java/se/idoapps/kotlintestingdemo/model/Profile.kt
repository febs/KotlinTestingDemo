package se.idoapps.kotlintestingdemo.model

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class Profile {
    var gender: GenderTypes = defaultGender()
    var birthDate: LocalDateTime = defaultBirthDate()
    var height: Int = 0
    var weight: Int = 0
    var physicalActivity: PhysicalActivityTypes = defaultPhysicalActivity()

    val age: Long
        get()
        {
            val fromDate = LocalDateTime.from(birthDate)
            return fromDate.until(LocalDateTime.now(), ChronoUnit.YEARS)
        }

    fun calculateDailyEnergyIntake(): Double {
        if (weight <= 0 || height <= 0)
        {
            return 0.0
        }

        // Harris-Benedict Equation
        // https://www.livestrong.com/article/178764-caloric-intake-formula/

        if (gender == GenderTypes.Male) {
            return (66.4730 + (13.7516 * weight) + (5.0033 * height) - (6.7550 * age)) * getActivityLevelFactor()
        }

        return (655.0955 + (9.5634 * weight) + (1.8496 * height) - (4.6756 * age)) * getActivityLevelFactor()
    }

    fun calculateDailyCarbIntake(): Int {
        return Math.round(calculateDailyEnergyIntake() * 0.65 / 4).toInt()
    }

    fun calculateDailyFatIntake(): Int {
        return Math.round(calculateDailyEnergyIntake() / 3 / 9).toInt()
    }

    fun calculateDailyProteinIntake(): Int {
        return Math.round(calculateDailyEnergyIntake() * 0.2 / 4).toInt()
    }

    fun getActivityLevelFactor(): Double {
        return when(physicalActivity) {
            PhysicalActivityTypes.NotActiveAtAll -> 1.2
            PhysicalActivityTypes.SlightlyActive -> 1.375
            PhysicalActivityTypes.Moderate -> 1.55
            PhysicalActivityTypes.Active -> 1.725
            PhysicalActivityTypes.VeryActive -> 1.9
        }
    }

    companion object {
        fun defaultGender(): GenderTypes = GenderTypes.Female
        fun defaultBirthDate(): LocalDateTime = LocalDateTime.of( 1980 , 1 , 1, 0, 0)
        fun defaultPhysicalActivity(): PhysicalActivityTypes = PhysicalActivityTypes.Moderate
    }
}

enum class GenderTypes {
    Male,
    Female
}

enum class PhysicalActivityTypes {
    NotActiveAtAll,
    SlightlyActive,
    Moderate,
    Active,
    VeryActive
}