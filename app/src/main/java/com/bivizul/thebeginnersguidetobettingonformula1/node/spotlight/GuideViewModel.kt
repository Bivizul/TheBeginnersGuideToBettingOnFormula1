package com.bivizul.thebeginnersguidetobettingonformula1.node.spotlight

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.Guide
import com.bivizul.thebeginnersguidetobettingonformula1.data.repository.GuideRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GuideViewModel @Inject constructor(private val guideRepository: GuideRepository) :
    ViewModel() {

    private val _guide = MutableLiveData<Guide>()
    val guide: LiveData<Guide> = _guide

    init {
        viewModelScope.launch {
            val response = guideRepository.getGuide()
            if (response.isSuccessful) {
                response.body()?.let {
                    _guide.postValue(it)
                }
            } else {
                _guide.postValue(Guide(listOf()))
            }
        }
    }
}