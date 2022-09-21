package com.example.flightapplication.ui.list

import android.R
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.example.flightapplication.databinding.FragmentListBinding
import com.example.flightapplication.ui.base.BaseFragment
import com.example.flightapplication.ui.list.adapters.DaysAdapter
import com.example.flightapplication.util.Constant
import com.example.flightapplication.util.Resource
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_list.view.*


@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding>(FragmentListBinding::inflate) {

    private val viewModel: ListViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter= DaysAdapter(this)
        viewModel.getFlights(requireContext())
        binding.tabLayout.getTabAt(2)?.select()
        binding.viewPager.adapter=adapter



        viewModel.flightData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            when (it) {
                is Resource.Success -> {
                    Log.e("eee data",it.data.toString())

                    TabLayoutMediator(binding.tabLayout,binding.viewPager){tab,position->
                        if (position==0){
                            tab.text="Önceki Gün \n ${it.data?.data?.priceHistory?.departure?.previousDayPrice} TL"
                        }
                        if (position==1){
                            tab.text="28 Haz Sal"
                        }
                        if (position==2){
                            tab.text="Sonraki Gün \n ${it.data?.data?.priceHistory?.departure?.nextDayPrice} TL"
                        }
                    }.attach()
                    Constant.dialog.dismiss()
                    binding.origin=it.data?.data?.searchParameters?.origin
                    binding.destination=it.data?.data?.searchParameters?.destination
                    binding.searchParameters=it?.data?.data?.searchParameters
                }
                is Resource.Error -> {
                    Log.e("eeee Error",it.message.toString())
                    Constant.dialog.dismiss()
                }
                is Resource.Loading -> {

                }
            }
        })
    }
}