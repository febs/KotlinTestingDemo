package se.idoapps.kotlintestingdemo.repository

import se.idoapps.kotlintestingdemo.model.Profile

interface ProfileRepositoryInterface {
    fun getProfile(): Profile?
    fun saveProfile(profile: Profile)
}

class ProfileRepository: ProfileRepositoryInterface {
    private var profile: Profile? = null

    override fun getProfile(): Profile? = profile

    override fun saveProfile(profile: Profile) {
        this.profile = profile
    }
}