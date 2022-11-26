package com.example.travelapp.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.travelapp.APP
import com.example.travelapp.R
import com.example.travelapp.ViewModel.AddHotelViewModel
import com.example.travelapp.databinding.FragmentAddHotelBinding
import com.example.travelapp.model.HotelModel

class AddHotel : Fragment() {

    companion object {
        fun newInstance() = AddHotel()
    }
    lateinit var binding: FragmentAddHotelBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddHotelBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(AddHotelViewModel::class.java)
        binding.CheckButton.setOnClickListener {
            val title = binding.etAddName.text.toString()
            val cost = binding.etAddCost.text.toString()
            val description = binding.etAddDescription.text.toString()
            viewModel.insert(HotelModel(null,name = title, description = description, cost = cost)){}
            APP.navController.navigate(R.id.action_addHotel_to_listHotel)
        }
        binding.BackButton.setOnClickListener {
            APP.navController.navigate(R.id.action_addHotel_to_listHotel)
        }

    }


}