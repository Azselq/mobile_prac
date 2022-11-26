package com.example.travelapp.db.dao

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.travelapp.model.HotelModel

@androidx.room.Database(entities = [HotelModel::class], version =1)
abstract class Database:RoomDatabase() {
    abstract fun getDao(): Dao

    companion object{
        private var database: Database ?= null
        @Synchronized
        fun getInstance(context: Context):Database{
            return if (database == null) {
                database = Room.databaseBuilder(context, Database::class.java, "hotel.db").build()
                database as Database
            }else
                database as Database
        }
    }
}