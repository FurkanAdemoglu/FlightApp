package com.example.flightapplication.ui.list


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.allViews
import androidx.core.view.children
import androidx.fragment.app.viewModels
import com.example.flightapplication.R
import com.example.flightapplication.databinding.FragmentListBinding
import com.example.flightapplication.ui.base.BaseFragment
import com.example.flightapplication.ui.list.adapters.DaysAdapter
import com.example.flightapplication.util.Constant
import com.example.flightapplication.util.Resource
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.view.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding>(FragmentListBinding::inflate) {

    private val viewModel: ListViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = DaysAdapter(this)
        viewModel.getFlights(requireContext())

        binding.viewPager.adapter = adapter
        viewModel.flightData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            when (it) {
                is Resource.Success -> {
                    TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
                        if (position == 0) {
                            tab.text =
                                "Önceki Gün \n ${it.data?.data?.priceHistory?.departure?.previousDayPrice} TL"
                        }
                        if (position == 1) {
                            val date = decodeDate(it.data?.data?.searchParameters?.departureDate)
                            tab.text =
                                "${date} \n ${it.data?.data?.filterBoundaries?.departurePrice?.min} TL"

                        }
                        if (position == 2) {
                            tab.text =
                                "Sonraki Gün \n ${it.data?.data?.priceHistory?.departure?.nextDayPrice} TL"
                        }
                    }.attach()
                    tabLayout.setScrollPosition(1, 0f, true);
                    viewPager.setCurrentItem(1);
                    Constant.dialog.dismiss()
                    binding.origin = it.data?.data?.searchParameters?.origin
                    binding.destination = it.data?.data?.searchParameters?.destination
                    binding.searchParameters = it?.data?.data?.searchParameters
                }
                is Resource.Error -> {
                    Log.e("eeee Error", it.message.toString())
                    Constant.dialog.dismiss()
                }
                is Resource.Loading -> {
                }
            }
        })
    }

    fun decodeDate(date: String?): String {
        val stringDate = date
        val sdf = SimpleDateFormat("dd MMM EEE", Locale("tr"))
        val sdfJson = SimpleDateFormat("yyyy-MM-dd")
        val date = sdfJson.parse(stringDate)
        System.out.println(sdf.format(date))
        return sdf.format(date)
    }
}