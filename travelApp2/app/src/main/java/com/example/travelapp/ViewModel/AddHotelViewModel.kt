package com.example.travelapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travelapp.REPOSITORY
import com.example.travelapp.model.HotelModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddHotelViewModel : ViewModel() {
   fun insert(hotelModel: HotelModel, onSuccess:() -> Unit) =
       viewModelScope.launch(Dispatchers.IO) {
           REPOSITORY.create(hotelModel){
               onSuccess()
           }
       }
}