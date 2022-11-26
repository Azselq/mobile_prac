package com.example.travelapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.travelapp.model.HotelModel


@androidx.room.Dao
interface Dao {
    @Insert
    suspend fun insertHotels(hotels: HotelModel)

    @Update
    suspend fun updateHotels(hotels: HotelModel)

    @Delete
    suspend fun  delete(hotels:HotelModel)

    @Query("SELECT * FROM hotel_table ")
    fun getAllHotels(): LiveData<List<HotelModel>>
}