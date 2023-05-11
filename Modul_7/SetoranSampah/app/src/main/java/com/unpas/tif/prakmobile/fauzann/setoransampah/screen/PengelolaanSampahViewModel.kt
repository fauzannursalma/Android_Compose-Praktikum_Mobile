package com.unpas.tif.prakmobile.fauzann.setoransampah.screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.unpas.tif.prakmobile.fauzann.setoransampah.model.SetoranSampah
import com.unpas.tif.prakmobile.fauzann.setoransampah.persistences.SetoranSampahDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PengelolaanSampahViewModel @Inject constructor(private val
                                                     setoranSampahDao: SetoranSampahDao) : ViewModel() {
    val list : LiveData<List<SetoranSampah>> = setoranSampahDao.loadAll()
    suspend fun insert(id: String,
                       tanggal: String,
                       nama: String,
                       berat: String){

        val item = SetoranSampah(id, tanggal, nama, berat)
        setoranSampahDao.insertAll(item)
    }
}