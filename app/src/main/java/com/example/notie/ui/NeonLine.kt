package com.example.notie.ui

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notie.R

@Composable
fun NeonLine(
  isLtr: Boolean = true
) {
  var boxWidth by remember { mutableStateOf(0.dp) }
  var reverseBoxWidth by remember { mutableStateOf(600.dp) }
  val animatedBoxWidth by animateDpAsState(
    targetValue = if (boxWidth == 0.dp) 350.dp else 0.dp,
    animationSpec = tween(durationMillis = 1500), label = ""
  )
  val reverseAnimatedBoxWidth by animateDpAsState(
    targetValue = if (reverseBoxWidth == 0.dp) 600.dp else 0.dp,
    animationSpec = tween(durationMillis = 1500), label = ""
  )

  Column(modifier = Modifier.fillMaxWidth()) {
    Box(
      modifier = if (isLtr) Modifier
        .padding(start = reverseAnimatedBoxWidth)
        .fillMaxWidth()
        .height(10.dp)
        .background(
          brush = fadeBackground(true)
        )
      else Modifier
        .height(10.dp)
        .background(
          brush = fadeBackground(true)
        )
        .width(animatedBoxWidth),
    )
    Box(
      modifier = if (isLtr) Modifier
        .padding(start = reverseAnimatedBoxWidth)
        .fillMaxWidth()
        .height(5.dp)
        .background(color = colorResource(id = R.color.white_blue))
        .border(width = 1.dp, color = colorResource(id = R.color.light_blue))
      else Modifier
        .height(5.dp)
        .background(color = colorResource(id = R.color.white_blue))
        .border(width = 1.dp, color = colorResource(id = R.color.light_blue))
        .width(animatedBoxWidth)
    ) {
      LaunchedEffect(Unit) {
        boxWidth = if (boxWidth == 350.dp) 0.dp else 350.dp
        reverseBoxWidth = if (reverseBoxWidth == 600.dp) 0.dp else 600.dp
      }
    }
    Box(
      modifier = if (isLtr) Modifier
        .padding(start = reverseAnimatedBoxWidth)
        .fillMaxWidth()
        .height(10.dp)
        .background(
          brush = fadeBackground(false)
        )
      else Modifier
        .height(10.dp)
        .background(
          brush = fadeBackground(false)
        )
        .width(animatedBoxWidth),
    )
  }
}

@Composable
fun fadeBackground(isTop: Boolean = false): Brush {
  return Brush.linearGradient(
    colors = listOf(
      colorResource(id = R.color.grey),
      Color.Transparent
    ),
    start = if (isTop) Offset(0f, Float.POSITIVE_INFINITY) else Offset(0f, 0f),
    end = if (isTop) Offset(0f, 0f) else Offset(0f, Float.POSITIVE_INFINITY),
  )
}

@Preview
@Composable
fun NeonLinePreview() {
  NeonLine(true)
}

