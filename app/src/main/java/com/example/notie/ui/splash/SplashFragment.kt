package com.example.notie.ui.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notie.R
import com.example.notie.ui.NeonLine
import com.example.notie.ui.theme.AudioWideFont
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
  navigateToListScreen: () -> Unit
) {
  LaunchedEffect(key1 = true) {
    delay(1500L)
    navigateToListScreen()
  }

  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(
        brush = Brush.radialGradient(
          colors = listOf(Color(0xB3656C83), Color(0xFF03033C)),
          center = Offset(0.5f, 0.5f),
          radius = 0.7f
        )
      ),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceBetween
  ) {
    NeonLine(false)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      Text(
        text = stringResource(id = R.string.capitalized_app_name), fontSize = 45.sp,
        fontFamily = AudioWideFont.fontFamily,
        color = Color.White,
      )
      Spacer(Modifier.height(2.dp))
      Text(
        text = stringResource(id = R.string.app_tagline), fontSize = 12.sp,
        fontFamily = AudioWideFont.fontFamily,
        color = Color.White,
      )
    }
    NeonLine(isLtr = true)
  }
}

@Composable
@Preview
fun SplashScreenPreview() {
  SplashScreen(navigateToListScreen = {})
}
