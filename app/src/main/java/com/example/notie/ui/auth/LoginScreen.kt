package com.example.notie.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.notie.R
import com.example.notie.ui.components.AppName
import com.example.notie.ui.components.PasswordInputLayout
import com.example.notie.ui.components.TextInputLayout
import com.example.notie.ui.theme.BackgroundGrey
import com.example.notie.ui.theme.DarkPaleBlue
import com.example.notie.ui.theme.FacebookBlue
import com.example.notie.ui.theme.LightBlue
import com.example.notie.ui.theme.LightPaleBlue
import com.example.notie.ui.theme.PlaypenSans

@Composable
fun LoginScreen(
  navigateToSignUpScreen: () -> Unit,
  navigateToForgetPasswordScreen: () -> Unit
) {
  ConstraintLayout(
    modifier = Modifier
      .fillMaxSize()
      .background(color = BackgroundGrey)
  ) {
    val (appName, signInTxt, emailTil, passwordTil, withEmailBtn, forgetPasswordBtn, divider, withFbBtn, withGmailBtn, signInBtn) = createRefs()
    Box(modifier = Modifier.constrainAs(appName) {
      linkTo(start = parent.start, end = parent.end)
      linkTo(top = parent.top, bottom = parent.bottom, bias = .10f)
    }) {
      AppName(titleColor = DarkPaleBlue, taglineColor = LightPaleBlue)
    }
    Text(
      text = stringResource(id = R.string.sign_in),
      fontFamily = PlaypenSans.regular,
      fontWeight = FontWeight.Bold,
      fontSize = 18.sp,
      modifier = Modifier.constrainAs(signInTxt) {
        linkTo(start = parent.start, end = parent.end)
        top.linkTo(appName.bottom, margin = 40.dp)
      })
    TextInputLayout(modifier = Modifier
      .constrainAs(emailTil) {
        linkTo(start = parent.start, end = parent.end)
        top.linkTo(signInTxt.bottom, margin = 20.dp)
      }
      .fillMaxWidth()
      .padding(horizontal = 60.dp, vertical = 10.dp),
      labelString = stringResource(id = R.string.email_txt),
      iconId = R.drawable.ic_mail)
    PasswordInputLayout(modifier = Modifier
      .constrainAs(passwordTil) {
        linkTo(start = parent.start, end = parent.end)
        top.linkTo(emailTil.bottom)
      }
      .fillMaxWidth()
      .padding(horizontal = 60.dp, vertical = 10.dp),
      labelString = stringResource(id = R.string.password), isLastField = true)
    Button(
      onClick = { /*TODO*/ },
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 60.dp, vertical = 10.dp)
        .constrainAs(withEmailBtn) {
          linkTo(start = parent.start, end = parent.end)
          top.linkTo(passwordTil.bottom)
        },
      elevation = ButtonDefaults.buttonElevation(8.dp),
      colors = ButtonDefaults.buttonColors(containerColor = LightBlue)
    ) {
      Text(
        text = stringResource(R.string.sign_in),
        fontFamily = PlaypenSans.regular,
        fontWeight = FontWeight.Bold,
        color = Color.White
      )
    }
    TextButton(onClick = { navigateToForgetPasswordScreen() }, modifier = Modifier.constrainAs(forgetPasswordBtn) {
      linkTo(start = parent.start, end = parent.end)
      top.linkTo(withEmailBtn.bottom)
    }) {
      Text(
        text = stringResource(id = R.string.forget_password),
        color = LightBlue,
        fontFamily = PlaypenSans.regular,
      )
    }
    Divider(
      modifier = Modifier
        .padding(horizontal = 100.dp, vertical = 25.dp)
        .constrainAs(divider) {
          linkTo(start = parent.start, end = parent.end)
          top.linkTo(forgetPasswordBtn.bottom)
        },
      color = Color.Gray,
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
      androidx.compose.material3.Text(
        text = stringResource(R.string.signin_with_facebook),
        fontFamily = PlaypenSans.regular,
        fontWeight = FontWeight.Bold,
        color = Color.White
      )
    }

    Button(
      onClick = { /*TODO*/ },
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 60.dp, vertical = 10.dp)
        .constrainAs(withGmailBtn) {
          linkTo(start = parent.start, end = parent.end)
          top.linkTo(withFbBtn.bottom)
        },
      elevation = ButtonDefaults.buttonElevation(8.dp),
      colors = ButtonDefaults.buttonColors(containerColor = Color.White)
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
        text = stringResource(R.string.signin_with_gmail),
        fontFamily = PlaypenSans.regular,
        fontWeight = FontWeight.Bold,
        color = Color.Black
      )
    }
    val annotatedString = buildAnnotatedString {
      withStyle(style = SpanStyle(color = Color.Gray)) {
        append(stringResource(id = R.string.dont_have_account))
      }
      withStyle(style = SpanStyle(color = LightBlue)) {
        append(stringResource(id = R.string.sign_up))
      }
    }
    TextButton(onClick = { navigateToSignUpScreen() }, modifier = Modifier.constrainAs(signInBtn) {
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
fun PreviewLoginScreen() {
  LoginScreen({}, {})
}