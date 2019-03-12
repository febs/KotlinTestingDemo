package se.idoapps.kotlintestingdemo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import se.idoapps.kotlintestingdemo.repository.ProfileRepositoryInterface
import se.idoapps.kotlintestingdemo.service.ProfileServiceInterface
import se.idoapps.kotlintestingdemo.viewmodel.ShowProfileViewModel
import se.idoapps.kotlintestingdemo.viewmodel.ShowProfileViewModelInterface
import org.mockito.Mockito.`when`
import se.idoapps.kotlintestingdemo.model.GenderTypes
import se.idoapps.kotlintestingdemo.model.PhysicalActivityTypes
import se.idoapps.kotlintestingdemo.model.Profile
import java.time.LocalDateTime


class TestShowProfileViewModel {
    private lateinit var subject: ShowProfileViewModelInterface
    private lateinit var profileService: ProfileServiceInterface

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun initTests() {
        profileService = mock()

        subject = ShowProfileViewModel(profileService)
    }

    @Test
    fun `When loading a profile and no profile exists an empty profile shall be returned`() {
        // ARRANGE
        `when`(profileService.hasProfile()).thenReturn(false)

        // ACT
        subject.loadProfile()

        // ASSERT
        assertNotNull(subject.currentProfile)

        assertEquals(Profile.defaultBirthDate(), subject.currentProfile?.birthDate)
        assertEquals(Profile.defaultGender(), subject.currentProfile?.gender)
        assertEquals(Profile.defaultPhysicalActivity(), subject.currentProfile?.physicalActivity)
        assertEquals(0, subject.currentProfile?.weight)
        assertEquals(0, subject.currentProfile?.height)
    }

    @Test
    fun `When loading a profile and a profile exists that profile shall be returned`() {
        // ARRANGE
        val profile = Profile()
        profile.birthDate = LocalDateTime.now().minusYears(45)
        profile.gender = GenderTypes.Male
        profile.weight = 105
        profile.height = 183
        profile.physicalActivity = PhysicalActivityTypes.Moderate

        `when`(profileService.hasProfile()).thenReturn(true)
        `when`(profileService.getProfile()).thenReturn(profile)

        // ACT
        subject.loadProfile()

        // ASSERT
        assertNotNull(subject.currentProfile)

        assertEquals(profile.birthDate, subject.currentProfile?.birthDate)
        assertEquals(profile.gender, subject.currentProfile?.gender)
        assertEquals(profile.physicalActivity, subject.currentProfile?.physicalActivity)
        assertEquals(profile.weight, subject.currentProfile?.weight)
        assertEquals(profile.height, subject.currentProfile?.height)
        assertEquals(45.toLong(), subject.currentProfile?.age)
    }

    @Test
    fun `When saving a profile that profile should be sent to the service`() {
        // ARRANGE
        val profile = Profile()
        profile.birthDate = LocalDateTime.now().minusYears(45)
        profile.gender = GenderTypes.Male
        profile.weight = 105
        profile.height = 183
        profile.physicalActivity = PhysicalActivityTypes.Moderate

        `when`(profileService.hasProfile()).thenReturn(true)
        `when`(profileService.getProfile()).thenReturn(profile)

        subject.loadProfile()

        // ACT
        subject.currentProfile!!.birthDate = LocalDateTime.now().minusYears(42)
        subject.currentProfile!!.gender = GenderTypes.Female
        subject.currentProfile!!.weight = 55
        subject.currentProfile!!.height = 168
        subject.currentProfile!!.physicalActivity = PhysicalActivityTypes.SlightlyActive

        subject.saveProfile()

        // ASSERT
        verify(profileService).saveProfile(subject.currentProfile!!)
    }
}