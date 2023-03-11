package com.example.myroom.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDatabase:RoomDatabase() {
    abstract fun studentDao():StudentDao
    companion object{
        @Volatile
        private var INSTANCE : StudentDatabase?=null
        fun getInstance(context: Context):StudentDatabase{
            synchronized(this){
                var instant =  INSTANCE
                if(instant == null){
                        instant = Room.databaseBuilder(
                            context.applicationContext,
                        StudentDatabase::class.java,
                            "student_data_database"
                        ).build()
                }
                return instant
            }
        }
    }

}