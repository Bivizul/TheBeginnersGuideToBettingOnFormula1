package com.bivizul.thebeginnersguidetobettingonformula1.data.repository

import android.util.Log
import com.bivizul.thebeginnersguidetobettingonformula1.data.OutService
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.GetBehome
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.Guide
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.SetBehome
import com.bivizul.thebeginnersguidetobettingonformula1.util.Resserv
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class GuideRepository @Inject constructor(private val outService: OutService) {

    suspend fun getGuide() = outService.getGuide()

    /*private val _guide = MutableSharedFlow<Guide>()
    val guide: SharedFlow<Guide> = _guide.asSharedFlow()

    suspend fun getGuide() {
//        _guide.emit(Resserv.LoadingR())
        val response = outService.getGuide()
        Log.e("qwer","GuideRepository response : $response")
        if (response.isSuccessful) {
            response.body()?.let {
                Log.e("qwer","GuideRepository response isSuccessful")
//                Log.e("qwer","GuideRepository getGuide : ${it.guide[0]}")
//                _guide.emit(Resserv.SuccessR(it))
                _guide.emit(it)
            }
        } else {
            Log.e("qwer","GuideRepository response Error")
//            _guide.emit(Resserv.ErrorR(response.message()))
            _guide.emit(Guide(listOf()))
        }
    }*/

}