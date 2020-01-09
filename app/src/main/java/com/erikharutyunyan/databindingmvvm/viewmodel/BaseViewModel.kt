package com.erikharutyunyan.databindingmvvm.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler

open class BaseViewModel : ViewModel() {
    val errorHandler = CoroutineExceptionHandler { _, exception ->
        Log.e("RequestException","Caught $exception with suppressed ${exception.suppressed!!.contentToString()}")
    }
}