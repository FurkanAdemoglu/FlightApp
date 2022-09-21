package com.example.flightapplication.ui.list

import android.content.Context
import android.provider.ContactsContract
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.flightapplication.model.entity.Data
import com.example.flightapplication.model.entity.Response
import com.example.flightapplication.repository.FlightListRepository
import com.example.flightapplication.ui.RxImmediateSchedulerRule
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.functions.Supplier
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import org.junit.*
import org.junit.Assert.*

import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.concurrent.Callable
import java.util.concurrent.Executor

class ListViewModelTest {
    @Mock
    lateinit var mockDataRepository: FlightListRepository

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()
    @Rule
    @JvmField
    val ruleForLivaData = InstantTaskExecutorRule()

    @Mock
    lateinit var mockLiveDataObserver: Observer<Response>

    lateinit var myViewModel: ListViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        myViewModel = ListViewModel()
    }

    @Before
    fun setUpRxSchedulers() {
        val immediate = object : Scheduler() {
            override fun createWorker(): Worker {
                return ExecutorScheduler.ExecutorWorker(Executor { it.run() }, true,true)
            }
        }

        RxJavaPlugins.setInitNewThreadSchedulerHandler { scheduler: Supplier<Scheduler> -> immediate }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler: Callable<Scheduler> -> immediate }
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getFlights(context: Context) {
        whenever(mockDataRepository.getFlightsFromAsset(context)).thenReturn(Observable.error(Throwable()))

        myViewModel.testLiveData.observeForever(mockLiveDataObserver)
        verify(mockLiveDataObserver, times(0)).onChanged(any())
    }


    @Test
    fun getFlightsFailure(context: Context){

        val testSingle = Observable.error<Response>(Throwable())
        Mockito.`when`(mockDataRepository.getFlightsFromAsset(context)).thenReturn(testSingle)
        Assert.assertEquals(null,myViewModel.testLiveDataFail.value)
    }
}