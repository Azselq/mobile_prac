package com.example.travelapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.travelapp.R
import com.example.travelapp.ViewModel.DetailHotelViewModel
import com.example.travelapp.databinding.ItemLayoutBinding
import com.example.travelapp.model.HotelModel
import com.example.travelapp.view.ListHotel

class HotelAdapter:RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {

    var listHotel = emptyList<HotelModel>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(view,parent,false)
        return HotelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        val hotel = listHotel[position]
        with(holder.binding){
            tvTitle.text = hotel.name
            tvCost.text = hotel.cost
        }
    }

    override fun getItemCount(): Int {
        return listHotel.size
    }
    class HotelViewHolder(val binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root)

    fun setList(list: List<HotelModel>){
        listHotel = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: HotelViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            ListHotel.open(listHotel[holder.adapterPosition])
        }

        holder.binding.imChange.setOnClickListener {
            ListHotel.updateHotel(listHotel[holder.adapterPosition])
        }
    }
    override fun onViewDetachedFromWindow(holder: HotelViewHolder) {
        holder.itemView.setOnClickListener(null)
    }

}