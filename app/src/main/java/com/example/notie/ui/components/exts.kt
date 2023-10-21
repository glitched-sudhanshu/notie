package com.example.notie.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
  val navGraphRoute = destination.parent?.route ?: return viewModel()
  val parentEntry = remember(this) {
    navController.getBackStackEntry(navGraphRoute)
  }
  return viewModel(parentEntry)
}