package com.bivizul.thebeginnersguidetobettingonformula1.data.repository

import com.bivizul.thebeginnersguidetobettingonformula1.data.OutService
import javax.inject.Inject

class GuideRepository @Inject constructor(private val outService: OutService) {

    suspend fun getGuide() = outService.getGuide()

}