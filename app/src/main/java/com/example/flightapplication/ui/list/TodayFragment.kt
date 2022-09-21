package com.example.flightapplication.ui.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.flightapplication.databinding.FragmentListBinding
import com.example.flightapplication.databinding.FragmentTodayBinding
import com.example.flightapplication.ui.base.BaseFragment
import com.example.flightapplication.ui.list.adapters.FlightTodayAdapter
import com.example.flightapplication.util.Constant
import com.example.flightapplication.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodayFragment : BaseFragment<FragmentTodayBinding>(FragmentTodayBinding::inflate) {
    private val viewModel: ListViewModel by viewModels()

    private val flightAdapter by lazy { FlightTodayAdapter(viewModel) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFlights(requireContext())
        binding.rvTodayFlight.adapter=flightAdapter
        viewModel.flightData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            when (it) {
                is Resource.Success -> {
                    Log.e("eee data",it.data.toString())
                    Constant.dialog.dismiss()
                    it.data?.data?.airlines?.forEach {airline->
                        viewModel.airlines.add(airline)
                    }

                    val filteredDeparture=it.data?.data?.flights?.departure?.filter { departure ->
                        departure.segments.getOrNull(0)?.departureDatetime?.date=="28.06.2022"
                    }

                    flightAdapter.submitList(filteredDeparture)
                }
                is Resource.Error -> {
                    Log.e("eeee Error",it.message.toString())
                    Constant.dialog.dismiss()
                }
                is Resource.Loading -> {
                   // Constant.showDialog(requireActivity())
                }
            }
        })
    }
}