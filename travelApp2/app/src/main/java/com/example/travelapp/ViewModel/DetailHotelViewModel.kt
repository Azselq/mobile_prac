package com.example.travelapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travelapp.REPOSITORY
import com.example.travelapp.model.HotelModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailHotelViewModel : ViewModel() {
    fun delete(hotelModel: HotelModel, onSuccess:() -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.delete(hotelModel){
                onSuccess()
            }
        }


}