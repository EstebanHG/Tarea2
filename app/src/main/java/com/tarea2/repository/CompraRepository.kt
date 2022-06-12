package com.tarea2.repository

import androidx.lifecycle.LiveData
import com.tarea2.data.CompraDao
import com.tarea2.model.Compra

class CompraRepository(private val compraDao: CompraDao) {

    suspend fun addCompra(compra : Compra){
        compraDao.addCompra(compra)
    }


    suspend fun updateCompra(compra : Compra){
        compraDao.updateCompra(compra)
    }


    suspend fun deleteCompra(compra : Compra){
        compraDao.deleteCompra(compra)
    }

    val getAllData : LiveData<List<Compra>> = compraDao.getAllData()



}