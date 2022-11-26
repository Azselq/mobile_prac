package com.example.travelapp.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.travelapp.APP
import com.example.travelapp.R
import com.example.travelapp.ViewModel.DetailHotelViewModel
import com.example.travelapp.databinding.FragmentDetailHotelBinding
import com.example.travelapp.model.HotelModel

class DetailHotel : Fragment() {
    lateinit var binding: FragmentDetailHotelBinding
    lateinit var currentHotel: HotelModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailHotelBinding.inflate(layoutInflater,container,false)
        currentHotel = arguments?.getSerializable("hotel") as HotelModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailHotelViewModel::class.java)
        binding.tvName.text = currentHotel.name
        binding.tvDesc.text = currentHotel.description
        binding.BackButton.setOnClickListener{
            APP.navController.navigate(R.id.action_detailHotel_to_listHotel)
        }

        binding.DeleteButton.setOnClickListener{
            viewModel.delete(currentHotel){}
            APP.navController.navigate(R.id.action_detailHotel_to_listHotel)
        }


    }

}