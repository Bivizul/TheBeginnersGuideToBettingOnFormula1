package com.bivizul.thebeginnersguidetobettingonformula1.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bivizul.thebeginnersguidetobettingonformula1.data.model.Guide

@Composable
fun ChildScreen(
    modifier: Modifier,
    color: Color,
    guide: Guide,
    id: Int,
) {
    val guideItem = guide.guide[id]

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = color,
                shape = RoundedCornerShape(6.dp)
            )
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = guideItem.title,
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.h4
            )
            Text(
                text = guideItem.descriptionTitle,
                modifier = modifier.padding(4.dp),
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.body1
            )
            if (!guideItem.subtitles.isNullOrEmpty()) {
                Column() {
                    guideItem.subtitles.forEach { subtitles ->
                        var visibility by remember { mutableStateOf(false) }
                        Button(
                            onClick = { visibility = !visibility },
                            modifier = modifier
                                .padding(4.dp)
                                .fillMaxWidth()
                        ) {
                            Column(
                                modifier = modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.Start
                            ) {
                                Text(
                                    text = subtitles.subtitle,
                                    style = MaterialTheme.typography.h5,
                                )
                                AnimatedVisibility(visible = visibility) {
                                    Text(
                                        text = subtitles.description,
                                        modifier = modifier.padding(vertical = 4.dp),
                                        style = MaterialTheme.typography.body2
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}