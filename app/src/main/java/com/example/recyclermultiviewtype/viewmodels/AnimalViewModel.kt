package com.example.recyclermultiviewtype.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclermultiviewtype.base.BaseItemModel
import com.example.recyclermultiviewtype.factory.ItemTypeFactory
import com.example.recyclermultiviewtype.model.Cat
import com.example.recyclermultiviewtype.model.Dog

class AnimalViewModel : ViewModel() {

    private val _catList = MutableLiveData<List<BaseItemModel>>();

    val catList = _catList


    fun getAnimalList() {
        var tempList = mutableListOf<BaseItemModel>(
            Cat("Cat1"), Dog("Dog1"), Cat("CatTwo")
        ,Cat("CatThree"), Dog("Dog2"),Dog("Dog3"), Dog("Dog4")
        )
        _catList.postValue(tempList);
    }
}