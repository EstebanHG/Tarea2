package com.tarea2.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tarea2.model.Compra


@Dao
interface CompraDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCompra(compra : Compra)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateCompra(compra : Compra)

    @Delete
    suspend fun deleteCompra(compra: Compra)

    @Query ("SELECT * FROM COMPRA")
    fun getAllData(): LiveData<List<Compra>>
        

}