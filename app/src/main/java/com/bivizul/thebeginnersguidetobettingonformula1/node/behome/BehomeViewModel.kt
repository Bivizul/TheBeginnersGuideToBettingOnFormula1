package com.bivizul.thebeginnersguidetobettingonformula1.node.behome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.SetBehome
import com.bivizul.thebeginnersguidetobettingonformula1.data.repository.BehomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BehomeViewModel @Inject constructor(private val behomeRepository: BehomeRepository) :
    ViewModel() {

    val behome = behomeRepository.behome

    fun setBehome(setBehome: SetBehome) {
        viewModelScope.launch {
            behomeRepository.getBehome(setBehome)
        }
    }

}