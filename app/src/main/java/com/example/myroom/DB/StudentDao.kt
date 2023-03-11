package com.example.myroom.DB

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {
    @Insert
    suspend fun insertStudent(student: Student)

    @Update
    suspend fun updateStudent(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)

    @Query("Select * From student_data_table")
    fun getAllStudents():LiveData<List<Student>>
}