package com.example.milsdesign

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Producto::class], version = 1)
abstract class AppDataBase2 : RoomDatabase() {
    abstract fun productos(): ProductosDao

    companion object{
        @Volatile
        private var INSTANCE: AppDataBase2? = null

        fun getDatabase2(context: Context): AppDataBase2{
            val tempInstance = INSTANCE

            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase2::class.java,
                    "app_database2"
                ).build()

                INSTANCE = instance

                return instance
            }
        }
    }
}