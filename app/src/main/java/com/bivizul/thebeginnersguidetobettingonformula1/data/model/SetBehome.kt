package com.bivizul.thebeginnersguidetobettingonformula1.data.model

import androidx.annotation.Keep

@Keep
data class SetBehome(
    val behomid: String,
    val setBehome: String,
    val timeZone: String,
    val simLoc: String,
    val manModel: String,
)
