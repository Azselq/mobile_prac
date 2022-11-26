package com.example.travelapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName ="hotel_table")
class HotelModel (
    @PrimaryKey(autoGenerate = true)
    var id: Int?=0,
    @ColumnInfo(name ="name")
    var name:String,
    @ColumnInfo(name ="description")
    var description: String,
    @ColumnInfo(name = "cost")
    var cost:String,
) : Serializable