package com.example.openweather.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WeatherViewModel : ViewModel() {
    private val username = MutableLiveData<String>()
    private val postalCode = MutableLiveData<String>()

    fun setIdentity(name: String?, post: String?) {
        username.postValue(name)
        postalCode.postValue(post)
    }

    fun getWeatherInfo() {

    }
}
