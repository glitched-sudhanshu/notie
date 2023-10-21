package com.example.notie.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notie.R
import com.example.notie.ui.auth.OnboardingScreen
import com.example.notie.ui.theme.AudioWideFont

@Composable
fun AppBanner() {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp))
      .gradientBackground(
        listOf(
          Color(0xB303279E), Color(0xFF0363F4), Color(0xFF0363F4), Color(
            0xFF03A9F4
          )
        ), angle = -45f
      )
      .padding(top = 50.dp, bottom = 30.dp),
    contentAlignment = Alignment.Center
  ) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
      Image(
        modifier = Modifier
          .size(100.dp),
        painter = painterResource(id = R.drawable.app_logo),
        contentDescription = stringResource(R.string.app_name),
      )
      AppName(titleSize = 40.sp)
    }
  }
}

@Preview
@Composable
fun PreviewAppBanner() {
  AppBanner()
}