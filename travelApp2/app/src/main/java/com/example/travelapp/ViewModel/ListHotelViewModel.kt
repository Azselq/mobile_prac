package com.example.travelapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travelapp.REPOSITORY
import com.example.travelapp.db.HotelRepository
import com.example.travelapp.db.dao.Database
import com.example.travelapp.model.HotelModel
import com.example.travelapp.view.ListHotel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListHotelViewModel(application: Application) : AndroidViewModel(application) {
    val context = application

    fun initDatabase(){
        val daoHotel = Database.getInstance(context).getDao()
        REPOSITORY = HotelRepository(daoHotel)
    }

   fun getAllHotels(): LiveData<List<HotelModel>>{
       return REPOSITORY.readAll
   }

}