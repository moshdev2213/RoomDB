package com.example.myroom

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myroom.DB.StudentDao

class StudentViewModalFactory(
    private val dao:StudentDao
) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StudentViewModel::class.java))
            return StudentViewModel(dao) as T
        throw java.lang.IllegalArgumentException("Unknown View Modal Class")
    }
}