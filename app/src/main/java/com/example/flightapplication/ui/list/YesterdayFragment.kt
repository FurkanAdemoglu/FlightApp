package com.example.flightapplication.ui.list

import androidx.fragment.app.viewModels
import com.example.flightapplication.databinding.FragmentListBinding
import com.example.flightapplication.databinding.FragmentYesterdayBinding
import com.example.flightapplication.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YesterdayFragment : BaseFragment<FragmentYesterdayBinding>(FragmentYesterdayBinding::inflate)  {
    private val viewModel: ListViewModel by viewModels()
}