package com.bivizul.thebeginnersguidetobettingonformula1.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class GetBehome(
    @SerializedName("url")
    val getBehome: String,
)
