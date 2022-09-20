package com.example.flightapplication.model.remote

import android.content.Context
import com.example.flightapplication.model.entity.Response
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable
import javax.inject.Inject

class AppDataManager @Inject constructor(private val gson: Gson) {

    private fun <V, T : V> Observable<T>.validate(context:Context): Observable<V> {
        return flatMap {
            try {
                val jsonString = context.assets.open("enuygun_flight_search.json").bufferedReader().use { it.readText() }
                val listPersonType = object : TypeToken<List<Response>>() {}.type


                        Observable.just(it)

            } catch (e: Throwable) {
                e.printStackTrace()
                val error = Throwable(message = e.toString())
                Observable.error(error)
            }
        }
    }
}