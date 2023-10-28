package com.example.notie.ui.auth.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.notie.R
import com.example.notie.ui.auth.SignInState
import com.example.notie.ui.auth.SignInViewModel
import com.example.notie.ui.components.AppName
import com.example.notie.ui.theme.BackgroundGrey
import com.example.notie.ui.theme.DarkPaleBlue
import com.example.notie.ui.theme.FacebookBlue
import com.example.notie.ui.theme.LightBlue
import com.example.notie.ui.theme.LightPaleBlue
import com.example.notie.ui.theme.PlaypenSans

@Composable
fun OnboardingScreen(
  navigateToSignUpScreen: () -> Unit,
  navigateToLoginScreen: () -> Unit,
  navigateToListScreen: () -> Unit,
  viewModel: SignInViewModel?,
  onSignInClick: () -> Unit
) {
  val signInState by viewModel!!.signInState.collectAsStateWithLifecycle()

  val context = LocalContext.current
  LaunchedEffect(key1 = signInState){
    when(signInState)
    {
      is SignInState.Error -> {
        Toast.makeText(context, (signInState as SignInState.Error).message.toString(), Toast.LENGTH_SHORT).show()
      }

      is SignInState.Success -> navigateToListScreen()

      else -> {}
    }
  }


  ConstraintLayout(
    modifier = Modifier
      .fillMaxSize()
      .background(color = BackgroundGrey),
  ) {
    val (appName, withEmailBtn, divider, withFbBtn, withGmailBtn, signUpBtn) = createRefs()
    Box(modifier = Modifier.constrainAs(appName) {
      linkTo(start = parent.start, end = parent.end)
      linkTo(top = parent.top, bottom = parent.bottom, bias = .30f)
    }){
      AppName(titleColor = DarkPaleBlue, taglineColor = LightPaleBlue)
    }
    Button(
      onClick = { navigateToSignUpScreen() },
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 60.dp, vertical = 10.dp)
        .constrainAs(withEmailBtn) {
          linkTo(start = parent.start, end = parent.end)
          top.linkTo(appName.bottom, margin = 55.dp)
        },
      elevation = ButtonDefaults.buttonElevation(8.dp),
      colors = ButtonDefaults.buttonColors(containerColor = LightBlue)
    ) {
      Text(
        text = stringResource(R.string.signup_with_email),
        fontFamily = PlaypenSans.regular,
        fontWeight = FontWeight.Bold,
        color = White
      )
    }
    Divider(
      modifier = Modifier
        .padding(horizontal = 100.dp, vertical = 25.dp)
        .constrainAs(divider) {
          linkTo(start = parent.start, end = parent.end)
          top.linkTo(withEmailBtn.bottom)
        },
      color = Gray,
      thickness = 1.dp
    )
    Button(
      onClick = { /*TODO*/ },
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 60.dp, vertical = 10.dp)
        .constrainAs(withFbBtn) {
          linkTo(start = parent.start, end = parent.end)
          top.linkTo(divider.bottom)
        },
      elevation = ButtonDefaults.buttonElevation(8.dp),
      colors = ButtonDefaults.buttonColors(containerColor = FacebookBlue)
    ) {
      Icon(
        painter = painterResource(id = R.drawable.ic_facebook),
        contentDescription = stringResource(
          id = R.string.signup_with_facebook
        ),
        tint = Color.Unspecified,
        modifier = Modifier
          .size(24.dp)
          .offset(x = (-14).dp)
      )
      Text(
        text = stringResource(R.string.signup_with_facebook),
        fontFamily = PlaypenSans.regular,
        fontWeight = FontWeight.Bold,
        color = White
      )
    }

    Button(
      onClick = { onSignInClick() },
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 60.dp, vertical = 10.dp)
        .constrainAs(withGmailBtn) {
          linkTo(start = parent.start, end = parent.end)
          top.linkTo(withFbBtn.bottom)
        },
      elevation = ButtonDefaults.buttonElevation(8.dp),
      colors = ButtonDefaults.buttonColors(containerColor = White)
    ) {
      Icon(
        painter = painterResource(id = R.drawable.ic_google), contentDescription = stringResource(
          id = R.string.signup_with_gmail
        ), modifier = Modifier
          .size(24.dp)
          .offset(x = (-14).dp),
        tint = Color.Unspecified
      )
      Text(
        text = stringResource(R.string.signup_with_gmail),
        fontFamily = PlaypenSans.regular,
        fontWeight = FontWeight.Bold,
        color = Black
      )
    }
    val annotatedString = buildAnnotatedString {
      withStyle(style = SpanStyle(color = Gray)) {
        append(stringResource(id = R.string.already_have_an_account))
      }
      withStyle(style = SpanStyle(color = LightBlue)) {
        append(stringResource(id = R.string.sign_in))
      }
    }
    TextButton(onClick = { navigateToLoginScreen() }, modifier = Modifier.constrainAs(signUpBtn) {
      bottom.linkTo(parent.bottom, margin = 10.dp)
      start.linkTo(parent.start)
      end.linkTo(parent.end)
    }) {
      Text(text = annotatedString, fontFamily = PlaypenSans.regular)
    }
  }
}

@Preview
@Composable
fun PreviewOnboardingScreen() {
  OnboardingScreen({}, {}, {}, null, {})
}