package com.example.notie.ui.components

import android.graphics.BlurMaskFilter
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import kotlin.math.min
import kotlin.math.pow

fun Modifier.gradientBackground(colors: List<Color>, angle: Float) = this.then(
  Modifier.drawBehind {
    // Setting the angle in radians
    val angleRad = angle / 180f * Math.PI
    // Fractional x
    val x = kotlin.math.cos(angleRad).toFloat()
    // Fractional y
    val y = kotlin.math.sin(angleRad).toFloat()
    // Set the Radius and offset as shown below
    val radius = kotlin.math.sqrt(size.width.pow(2) + size.height.pow(2)) / 2f
    val offset = center + Offset(x * radius, y * radius)
    // Setting the exact offset
    val exactOffset = Offset(
      x = min(offset.x.coerceAtLeast(0f), size.width),
      y = size.height - min(offset.y.coerceAtLeast(0f), size.height)
    )
    // Draw a rectangle with the above values
    drawRect(
      brush = Brush.linearGradient(
        colors = colors,
        start = Offset(size.width, size.height) - exactOffset,
        end = exactOffset
      ),
      size = size
    )
  }
)

fun Modifier.shadow(
  color: Color = Color.Black,
  borderRadius: Dp = 0.dp,
  blurRadius: Dp = 0.dp,
  offsetY: Dp = 0.dp,
  offsetX: Dp = 0.dp,
  spread: Dp = 0f.dp,
  modifier: Modifier = Modifier
) = this.then(
  modifier.drawBehind {
    this.drawIntoCanvas {
      val paint = Paint()
      val frameworkPaint = paint.asFrameworkPaint()
      val spreadPixel = spread.toPx()
      val leftPixel = (0f - spreadPixel) + offsetX.toPx()
      val topPixel = (0f - spreadPixel) + offsetY.toPx()
      val rightPixel = (this.size.width + spreadPixel)
      val bottomPixel = (this.size.height + spreadPixel)

      if (blurRadius != 0.dp) {
        frameworkPaint.maskFilter =
          (BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL))
      }

      frameworkPaint.color = color.toArgb()
      it.drawRoundRect(
        left = leftPixel,
        top = topPixel,
        right = rightPixel,
        bottom = bottomPixel,
        radiusX = borderRadius.toPx(),
        radiusY = borderRadius.toPx(),
        paint
      )
    }
  }
)

