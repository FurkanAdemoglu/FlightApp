package com.example.flightapplication.ui.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.flightapplication.databinding.FragmentListBinding
import com.example.flightapplication.databinding.FragmentYesterdayBinding
import com.example.flightapplication.ui.base.BaseFragment
import com.example.flightapplication.ui.list.adapters.FlightTomorrowAdapter
import com.example.flightapplication.util.Constant
import com.example.flightapplication.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YesterdayFragment :
    BaseFragment<FragmentYesterdayBinding>(FragmentYesterdayBinding::inflate) {
    private val viewModel: ListViewModel by viewModels()

    private val flightAdapter by lazy { FlightTomorrowAdapter(viewModel) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFlights(requireContext())
        binding.rvYesterday.adapter = flightAdapter
        viewModel.flightData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            when (it) {
                is Resource.Success -> {
                    Constant.dialog.dismiss()
                    it.data?.data?.airlines?.forEach { airline ->
                        viewModel.airlines.add(airline)
                    }

                    val filteredDeparture = it.data?.data?.flights?.departure?.filter { departure ->
                        val segment = departure.segments.filter { segment ->
                            segment.departureDatetime.date == "27.06.2022"
                        }
                        segment.isNullOrEmpty().not()
                    }
                    if (filteredDeparture.isNullOrEmpty()) {
                        binding.emptyFlightText.visibility = View.VISIBLE
                        binding.rvYesterday.visibility = View.GONE
                    } else {
                        binding.emptyFlightText.visibility = View.GONE
                        binding.rvYesterday.visibility = View.VISIBLE
                        flightAdapter.submitList(filteredDeparture)
                    }

                }
                is Resource.Error -> {
                    Constant.dialog.dismiss()
                }
                is Resource.Loading -> {
                    Constant.showDialog(requireActivity())
                }
            }
        })
    }
}