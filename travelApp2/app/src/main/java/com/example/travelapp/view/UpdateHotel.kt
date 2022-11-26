package com.example.travelapp.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.travelapp.APP
import com.example.travelapp.R
import com.example.travelapp.ViewModel.UpdateHotelViewModel
import com.example.travelapp.databinding.FragmentAddHotelBinding
import com.example.travelapp.databinding.FragmentUpdateHotelBinding
import com.example.travelapp.model.HotelModel

class UpdateHotel : Fragment() {


    lateinit var binding:FragmentUpdateHotelBinding
    lateinit var currentHotel: HotelModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateHotelBinding.inflate(layoutInflater,container,false)
        currentHotel = arguments?.getSerializable("hotel") as HotelModel
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(UpdateHotelViewModel::class.java)
        binding.CheckButton1.setOnClickListener {
            val title = binding.etAddName1.text.toString()
            val cost = binding.etAddCost1.text.toString()
            val description = binding.etAddDescription1.text.toString()
            viewModel.update(
                HotelModel(
                    currentHotel.id,
                    name = title,
                    description = description,
                    cost = cost
                )
            ) {}

            APP.navController.navigate(R.id.action_updateHotel_to_listHotel)
        }

        binding.BackButton1.setOnClickListener {
            APP.navController.navigate(R.id.action_updateHotel_to_listHotel)
        }
    }



}