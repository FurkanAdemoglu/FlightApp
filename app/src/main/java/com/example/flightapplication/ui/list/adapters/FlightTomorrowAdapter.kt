package com.example.flightapplication.ui.list.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.flightapplication.R
import com.example.flightapplication.databinding.ItemFlightBinding
import com.example.flightapplication.model.entity.Departure
import com.example.flightapplication.ui.list.ListViewModel

class FlightTomorrowAdapter (val viewModel: ListViewModel) : ListAdapter<Departure, FlightTomorrowAdapter.FlightViewHolder>(DIFF_UTIL) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemFlightBinding>(
            inflater,
            R.layout.item_flight,
            parent,
            false
        )
        return FlightViewHolder(binding,viewModel)
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
    companion object{
        val DIFF_UTIL= object : DiffUtil.ItemCallback<Departure>(){
            override fun areItemsTheSame(oldItem: Departure, newItem: Departure): Boolean {
                return false
            }

            override fun areContentsTheSame(oldItem: Departure, newItem: Departure): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    }

    class FlightViewHolder(val binding: ItemFlightBinding, val viewModel: ListViewModel):
        RecyclerView.ViewHolder(binding.root){
        fun bind(item: Departure){
            binding.segment=item.segments.getOrNull(0)
            binding.departure=item
            binding.baggageInfo=item.infos.baggageİnfo

            val filteredAirline=viewModel.airlines.filter { airline ->
                item.segments.getOrNull(0)?.marketingAirline==airline.code
            }

            Glide.with(binding.airlineImage.context)
                .load(filteredAirline.getOrNull(0)?.image)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(binding.airlineImage)
            binding.airlineName.text=filteredAirline.getOrNull(0)?.name
        }
    }
}