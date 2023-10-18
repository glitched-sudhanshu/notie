package com.example.notie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notie.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {

  private lateinit var mBinding: FragmentSplashBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    mBinding = FragmentSplashBinding.inflate(layoutInflater, container, false)
    return mBinding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    mBinding.splashComposeView.setContent {
      SplashScreen()
    }
  }

  @Composable
  fun SplashScreen() {
    Column(
      modifier = Modifier.fillMaxSize(),
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
    SplashScreen()
  }
}