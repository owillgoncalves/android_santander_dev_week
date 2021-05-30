package com.williammago.santanderdevweek.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.williammago.santanderdevweek.data.Account
import com.williammago.santanderdevweek.data.local.FakeData

class MainViewModel : ViewModel() {

    private val mutableLiveData : MutableLiveData<Account> = MutableLiveData()

    fun searchClientAccount() : LiveData<Account> {
        mutableLiveData.value = FakeData().getLocalData()

        return mutableLiveData
    }

}