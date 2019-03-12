package se.idoapps.kotlintestingdemo.service

import se.idoapps.kotlintestingdemo.model.Profile
import se.idoapps.kotlintestingdemo.repository.ProfileRepositoryInterface
import javax.inject.Inject

interface ProfileServiceInterface {
    fun getProfile(): Profile?
    fun saveProfile(profile: Profile)
    fun hasProfile(): Boolean
}

class ProfileService @Inject constructor (private val profileRepository: ProfileRepositoryInterface): ProfileServiceInterface {
    override fun getProfile(): Profile? = profileRepository.getProfile()
    override fun saveProfile(profile: Profile) = profileRepository.saveProfile(profile)
    override fun hasProfile(): Boolean = profileRepository.getProfile() != null
}