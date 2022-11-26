package com.example.travelapp.db

import androidx.lifecycle.LiveData
import com.example.travelapp.db.dao.Dao
import com.example.travelapp.model.HotelModel

class HotelRepository(private val hotelDao: Dao): DatabaseRepository {

    override val readAll: LiveData<List<HotelModel>>
        get() = hotelDao.getAllHotels()

    override suspend fun create(hotels: HotelModel, onSuccess: () -> Unit) {
        hotelDao.insertHotels(hotels)
        onSuccess()
    }

    override suspend fun update(hotels: HotelModel, onSuccess: () -> Unit) {
        hotelDao.updateHotels(hotels)
        onSuccess()
    }

    override suspend fun delete(hotels: HotelModel, onSuccess: () -> Unit) {
        hotelDao.delete(hotels)
        onSuccess()
    }
}