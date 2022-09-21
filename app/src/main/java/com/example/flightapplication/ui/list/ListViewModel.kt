package com.example.flightapplication.ui.list

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flightapplication.model.entity.Airline
import com.example.flightapplication.model.entity.Response
import com.example.flightapplication.repository.FlightListRepository
import com.example.flightapplication.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor() : ViewModel() {

    private val repository = FlightListRepository()
    private val compositeDisposable = CompositeDisposable()
    val flightData = MutableLiveData<Resource<Response>>()

    val testLiveData = MutableLiveData<Response>()
    val testLiveDataFail = MutableLiveData<Response?>()

    val airlines = mutableListOf<Airline>()

    fun getFlights(context: Context) {
        flightData.postValue(Resource.Loading())
        val observable = repository.getFlightsFromAsset(context)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { c ->
                    flightData.postValue(Resource.Success(c))
                    testLiveData.postValue(c)
                },
                { x ->
                    flightData.postValue(Resource.Error(x.message.toString(), null))
                    testLiveDataFail.postValue(null)
                })

        compositeDisposable.add(observable)
    }

}