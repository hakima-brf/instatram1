package com.example.instatram.data

import retrofit2.Call
import retrofit2.http.GET

interface StationService {
    @GET("6090a297d64cd16802a8e804")
    fun getStationData () : Call<List<Station>>
}