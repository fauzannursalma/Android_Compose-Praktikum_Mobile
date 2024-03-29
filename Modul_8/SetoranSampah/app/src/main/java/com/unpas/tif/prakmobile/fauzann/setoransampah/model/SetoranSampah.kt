package com.unpas.tif.prakmobile.fauzann.setoransampah.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SetoranSampah(
    @PrimaryKey val id: String,
    val tanggal: String,
    val nama: String,
    val berat: String,
)