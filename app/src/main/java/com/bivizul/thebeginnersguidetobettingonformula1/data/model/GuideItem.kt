package com.bivizul.thebeginnersguidetobettingonformula1.data.model

import androidx.annotation.Keep

@Keep
data class GuideItem(
    val title: String,
    val descriptionTitle: String,
    val subtitles: List<Subtitles>,
)