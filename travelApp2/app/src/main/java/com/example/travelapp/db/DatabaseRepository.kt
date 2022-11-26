package com.example.travelapp.db

import androidx.lifecycle.LiveData
import com.example.travelapp.model.HotelModel

interface DatabaseRepository {
    val readAll: LiveData<List<HotelModel>>

    suspend fun create(hotels: HotelModel, onSuccess:() -> Unit)
    suspend fun update(hotels: HotelModel, onSuccess:() -> Unit)
    suspend fun delete(hotels: HotelModel, onSuccess:() -> Unit)
}