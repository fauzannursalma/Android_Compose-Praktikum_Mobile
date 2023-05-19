package com.unpas.tif.prakmobile.fauzann.setoransampah.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import com.unpas.tif.prakmobile.fauzann.setoransampah.model.SetoranSampah

@Database(entities = [SetoranSampah::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun setoranSampahDao(): SetoranSampahDao
}