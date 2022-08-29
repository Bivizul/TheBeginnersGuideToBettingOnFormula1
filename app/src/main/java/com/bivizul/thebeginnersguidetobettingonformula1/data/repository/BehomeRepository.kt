package com.bivizul.thebeginnersguidetobettingonformula1.data.repository

import com.bivizul.thebeginnersguidetobettingonformula1.data.OutService
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.GetBehome
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.SetBehome
import com.bivizul.thebeginnersguidetobettingonformula1.util.Resserv
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class BehomeRepository @Inject constructor(private val outService: OutService) {

    private val _behome = MutableSharedFlow<Resserv<GetBehome>>()
    val behome: SharedFlow<Resserv<GetBehome>> = _behome.asSharedFlow()

    suspend fun getBehome(setBehome: SetBehome) {
        _behome.emit(Resserv.LoadingR())
        val response = outService.getBehome(setBehome)
        if (response.isSuccessful) {
            response.body()?.let {
                _behome.emit(Resserv.SuccessR(it))
            }
        } else {
            _behome.emit(Resserv.ErrorR(response.message()))
        }
    }
}