package com.tarea2.viewmodel


import android.app.Application
import androidx.lifecycle.*
import com.tarea2.data.CompraDao
import com.tarea2.data.CompraDatabase
import com.tarea2.model.Compra
import com.tarea2.repository.CompraRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CompraViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CompraRepository

    val getAllData: LiveData<List<Compra>>

    init {
        val compraDao = CompraDatabase.getDatabase(application).compraDao()
        repository = CompraRepository(compraDao)
        getAllData = repository.getAllData
    }

    fun addCompra(compra: Compra)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCompra(compra)
        }
    }
    fun updateCompra(compra: Compra)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateCompra(compra)
        }
    }
    fun deleteCompra(compra: Compra)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCompra(compra)
        }
    }

}