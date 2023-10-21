package com.example.notie.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notie.R
import com.example.notie.ui.theme.AudioWideFont

@Composable
fun AppName(titleSize: TextUnit = 45.sp, taglineSize: TextUnit = 12.sp, titleColor: Color = Color.White, taglineColor: Color = Color.White){
  Column(horizontalAlignment = Alignment.CenterHorizontally) {
    Text(
      text = stringResource(id = R.string.capitalized_app_name), fontSize = titleSize,
      fontFamily = AudioWideFont.fontFamily, fontWeight = FontWeight.ExtraBold,
      color = titleColor,
    )
    Spacer(Modifier.height(2.dp))
    Text(
      text = stringResource(id = R.string.app_tagline), fontSize = taglineSize,
      fontFamily = AudioWideFont.fontFamily,
      fontWeight = FontWeight.Thin,
      letterSpacing = 4.sp,
      color = taglineColor,
    )
  }
}

@Preview
@Composable
fun PreviewAppName()
{
  AppName()
}