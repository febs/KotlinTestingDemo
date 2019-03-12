package se.idoapps.kotlintestingdemo.viewmodel

import se.idoapps.kotlintestingdemo.model.Profile
import se.idoapps.kotlintestingdemo.service.ProfileServiceInterface
import javax.inject.Inject

interface ShowProfileViewModelInterface {
    var currentProfile: Profile?

    fun loadProfile()
    fun saveProfile()
}

class ShowProfileViewModel @Inject constructor (private val profileService: ProfileServiceInterface): ShowProfileViewModelInterface {
    override var currentProfile: Profile? = null

    override fun loadProfile() {
        if (profileService.hasProfile()) {
            currentProfile = profileService.getProfile()
            return
        }

        currentProfile = Profile()
    }

    override fun saveProfile() {
        if (currentProfile == null) {
            return
        }

        profileService.saveProfile(currentProfile ?: Profile())
    }
}