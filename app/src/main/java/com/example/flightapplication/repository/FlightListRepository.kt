package com.example.flightapplication.repository

import android.content.Context
import com.example.flightapplication.model.entity.Response
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxjava3.core.Observable

class FlightListRepository {
    fun getFlightsFromAsset(context: Context): Observable<Response> {
        val jsonString =
            context.assets.open("enuygun_flight_search.json").bufferedReader().use { it.readText() }
        val listPersonType = object : TypeToken<Response>() {}.type
        val gson = Gson()
        var persons: Response = gson.fromJson(jsonString, listPersonType)
        //Log.i("data", "> Item $idx:\n$person")
        return Observable.just(persons)
    }
}