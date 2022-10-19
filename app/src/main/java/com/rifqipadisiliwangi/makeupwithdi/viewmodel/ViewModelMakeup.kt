package com.rifqipadisiliwangi.makeupwithdi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rifqipadisiliwangi.makeupwithdi.model.ResponDataMakeup
import com.rifqipadisiliwangi.makeupwithdi.model.ResponDataMakeupItem
import com.rifqipadisiliwangi.makeupwithdi.network.RestfulApi
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.security.auth.callback.Callback


@HiltViewModel
class ViewModelMakeup @Inject constructor(var api : RestfulApi): ViewModel()  {

    lateinit var liveDataMakeup: MutableLiveData<List<ResponDataMakeupItem>>

    init {
        liveDataMakeup = MutableLiveData()
    }

    fun getliveDataMakeup() :MutableLiveData<List<ResponDataMakeupItem>>{
        return liveDataMakeup
    }

    fun callApiMakeup(){
        api.getMakeUp()
            .enqueue(object : retrofit2.Callback<List<ResponDataMakeupItem>>{
                override fun onResponse(
                    call: Call<List<ResponDataMakeupItem>>,
                    response: Response<List<ResponDataMakeupItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataMakeup.postValue(response.body())
                    }else{
                        liveDataMakeup.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponDataMakeupItem>>, t: Throwable) {
                    liveDataMakeup.postValue(null)
                }

            })
    }

}