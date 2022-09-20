package com.example.flightapplication.ui.list.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.flightapplication.ui.list.TodayFragment
import com.example.flightapplication.ui.list.TomorrowFragment
import com.example.flightapplication.ui.list.YesterdayFragment

class DaysAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return YesterdayFragment()
            1 -> return TodayFragment()
            2 -> return TomorrowFragment()
        }
        return TodayFragment()
    }
}