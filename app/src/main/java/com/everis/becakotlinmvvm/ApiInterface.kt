package com.everis.becakotlinmvvm

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("PublicHolidays/2021/br")
    fun getHolidays(): Call<List<HolidayModel>>
}