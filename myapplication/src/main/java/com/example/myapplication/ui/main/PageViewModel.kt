package com.example.myapplication.ui.main

import android.content.Context
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.TestView
import com.example.myapplication.TestView2

class PageViewModel : ViewModel() {

//    private val _index = MutableLiveData<Int>()
//    val text: LiveData<String> = Transformations.map(_index) {
//        "Hello world from section: $it"
//    }

//    fun setIndex(index: Int) {
//        _index.value = index
//    }
    val views= arrayListOf<View>()
    fun getItemView(context:Context) {
        views.add(TestView(context,null))
        views.add(TestView2(context,null))
    }
}