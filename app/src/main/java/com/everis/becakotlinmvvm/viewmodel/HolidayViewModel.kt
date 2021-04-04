package com.everis.becakotlinmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.everis.becakotlinmvvm.model.repository.HolidayRepository
import com.everis.becakotlinmvvm.model.HolidayModel

class HolidayViewModel: ViewModel() {
    
    var holidayRepository: HolidayRepository? = null
    var listHollidaysResult: MutableLiveData<List<HolidayModel>>? = null

    init {
        holidayRepository = HolidayRepository()
    }

    fun getHolidays(): LiveData<List<HolidayModel>> {
        if (listHollidaysResult == null) {
            listHollidaysResult = holidayRepository!!.fetchHolidays()
        }

        return listHollidaysResult!!
    }

}