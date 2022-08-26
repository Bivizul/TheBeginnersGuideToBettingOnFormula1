package com.bivizul.thebeginnersguidetobettingonformula1.data

import com.bivizul.thebeginnersguidetobettingonformula1.data.model.GetBehome
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.Guide
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.SetBehome
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface OutService {

    @GET("25TheBeginnersGuideToBettingOnFormula1/guide.json")
    suspend fun getGuide(): Response<Guide>

    @POST("25TheBeginnersGuideToBettingOnFormula1/behome.php")
    suspend fun getBehome(@Body setBehome: SetBehome): Response<GetBehome>

}