package com.example.travelapp.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.get
import androidx.recyclerview.widget.RecyclerView
import com.example.travelapp.APP
import com.example.travelapp.R
import com.example.travelapp.ViewModel.ListHotelViewModel
import com.example.travelapp.adapter.HotelAdapter
import com.example.travelapp.databinding.ItemListBinding
import com.example.travelapp.model.HotelModel

class ListHotel : Fragment() {

    lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: ListHotelViewModel
    lateinit var binding: ItemListBinding
    lateinit var adapter:HotelAdapter
    companion object {
        fun open(hotelModel: HotelModel){
            val bundle = Bundle()
            bundle.putSerializable("hotel", hotelModel)
            APP.navController.navigate(R.id.action_listHotel_to_detailHotel,bundle)
        }
        fun updateHotel(hotelModel: HotelModel){
            val bundle = Bundle()
            bundle.putSerializable("hotel", hotelModel)
            APP.navController.navigate(R.id.action_listHotel_to_updateHotel,bundle)
        }
        fun newInstance() = ListHotel()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemListBinding.inflate(layoutInflater,container,false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        viewModel = ViewModelProvider(this).get(ListHotelViewModel::class.java)
        viewModel.initDatabase()
        recyclerView = binding.rcView
        adapter = HotelAdapter()
        recyclerView.adapter = adapter
        viewModel.getAllHotels().observe(viewLifecycleOwner,{listHotels ->
            adapter.setList(listHotels.asReversed())
        })
        binding.addButton.setOnClickListener{
            APP.navController.navigate(R.id.action_listHotel_to_addHotel)
        }

    }
}