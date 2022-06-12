package com.tarea2.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tarea2.model.Compra

@Database(entities = [Compra :: class], version = 1, exportSchema = false)
abstract class CompraDatabase: RoomDatabase() {
    abstract fun compraDao() : CompraDao

    companion object {

        @Volatile
        private var INSTANCE: CompraDatabase? = null

        fun getDatabase(context: android.content.Context) : CompraDatabase {
            val temp = INSTANCE
            if (temp != null) {
                return temp
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CompraDatabase::class.java,
                    "lugar_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }
}