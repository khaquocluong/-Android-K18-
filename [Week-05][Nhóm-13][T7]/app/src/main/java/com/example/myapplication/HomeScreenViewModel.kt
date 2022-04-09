package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.myapplication.Model.Restaurant

enum class Error{
    ERROR_EMAIL,
    ERROR_PASSWORD,
}

class Resp(val isSuccess: Boolean, val error: Error?)

class HomeScreenViewModel : ViewModel(){


    private var _listOfData: MutableLiveData<List<Restaurant>> = MutableLiveData()
    val listOfData: LiveData<List<Restaurant>>
        get() = _listOfData

    fun loadData() {
        val data = DataStoreRes.getDataSet()
        _listOfData.postValue(data)
    }


}