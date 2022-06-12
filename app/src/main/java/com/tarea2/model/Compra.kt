package com.tarea2.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName="compra")
data class Compra(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo(name = "nombre")
    val nombre : String,
    @ColumnInfo(name = "correo")
    val correo : String?,
    @ColumnInfo(name = "telefono")
    val telefono : String?,
    @ColumnInfo(name = "web")
    val web : String?,
    @ColumnInfo(name = "cantidad")
    val cantidad : String?,
    @ColumnInfo(name = "precio")
    val precio : String?,
    @ColumnInfo(name = "compraImagen")
    val compraImagen : String?,

) : Parcelable
