package com.bivizul.thebeginnersguidetobettingonformula1.node.guide

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.Guide
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.SetBehome
import com.bivizul.thebeginnersguidetobettingonformula1.data.repository.GuideRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GuideViewModel @Inject constructor(private val guideRepository: GuideRepository) :
    ViewModel() {

    private val _guide = MutableLiveData<Guide>()
    val guide: LiveData<Guide> = _guide

    init{
        viewModelScope.launch {
            val response = guideRepository.getGuide()
            if (response.isSuccessful) {
                response.body()?.let {
                    Log.e("qwer","GuideViewModel response isSuccessful")
                    _guide.postValue(it)
                }
            } else {
                Log.e("qwer","GuideViewModel response Error")
//            _guide.emit(Resserv.ErrorR(response.message()))
                _guide.postValue(Guide(listOf()))
            }
        }
    }

    /*val guide = guideRepository.guide

    init {
        viewModelScope.launch {
            guideRepository.getGuide()
        }
    }*/

}