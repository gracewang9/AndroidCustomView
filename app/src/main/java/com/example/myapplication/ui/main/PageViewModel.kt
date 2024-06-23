package com.example.myapplication.ui.main

import android.content.Context
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.myapplication.view.*

class PageViewModel : ViewModel() {
    private val _index = MutableLiveData<Int>()
//    val text: LiveData<String> = Transformations.map(_index) {
//        "Hello world from section: $it"
//    }

    fun setIndex(index: Int) {
        _index.value = index
    }
    val views= arrayListOf<View>()
    fun setAddView(context: Context?){
        views.add(MultipleLinearView(context))
        views.add(AvatarXfermodeView(context))
        views.add(DashboardView(context))
        views.add(MaskFilterView(context))
        views.add(PaintStyleView(context))
        views.add(PathView(context))
        views.add(PieView(context))
        views.add(PorterDuffView(context))
        views.add(ShaderView(context))
        views.add(XfermodeView(context))
    }
}