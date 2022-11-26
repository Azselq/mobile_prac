package com.example.travelapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travelapp.REPOSITORY
import com.example.travelapp.model.HotelModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateHotelViewModel : ViewModel() {
    fun update(hotelModel: HotelModel, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.update(hotelModel){
                onSuccess()
            }
        }
}