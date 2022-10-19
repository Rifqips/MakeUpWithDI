package com.rifqipadisiliwangi.makeupwithdi.network

import com.rifqipadisiliwangi.makeupwithdi.model.ResponDataMakeupItem
import retrofit2.Call
import retrofit2.http.GET


interface RestfulApi {

    @GET("api/v1/products.json")
    fun getMakeUp(): Call<List<ResponDataMakeupItem>>
}