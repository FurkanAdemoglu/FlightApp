package com.example.flightapplication.ui.list

import androidx.fragment.app.viewModels
import com.example.flightapplication.databinding.FragmentListBinding
import com.example.flightapplication.databinding.FragmentTomorrowBinding
import com.example.flightapplication.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TomorrowFragment : BaseFragment<FragmentTomorrowBinding>(FragmentTomorrowBinding::inflate) {
    private val viewModel: ListViewModel by viewModels()
}