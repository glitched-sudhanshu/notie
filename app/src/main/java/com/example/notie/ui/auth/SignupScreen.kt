package com.example.notie.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.notie.ui.components.CheckboxComponent
import com.example.notie.ui.components.PasswordInputLayout
import com.example.notie.ui.components.TextInputLayout
import com.example.notie.ui.theme.BackgroundGrey
import com.example.notie.ui.theme.DarkPaleBlue
import com.example.notie.ui.theme.LightBlue
import com.example.notie.ui.theme.LightPaleBlue
import com.example.notie.ui.theme.PlaypenSans

@Composable
fun SignupScreen(
  navigateToLoginScreen: () -> Unit,
) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(color = BackgroundGrey)
      .verticalScroll(rememberScrollState())
  ) {
    ConstraintLayout(
      modifier = Modifier
        .fillMaxSize()
    ) {
      val username = remember { mutableStateOf("") }
      val mobileNo = remember { mutableStateOf("") }
      val dateOfBirth = remember { mutableStateOf("") }
      val occupation = remember { mutableStateOf("") }
      val email = remember { mutableStateOf("") }
      val password = remember { mutableStateOf("") }
      val confirmPassword = remember { mutableStateOf("") }
      val tncCheck = remember { mutableStateOf(false) }

      val (appName, signUpTxt, usernameTil, phoneNoTil, dobTil, emailTil, occupationTil, passwordTil, confirmPasswordTil, tNcCheckbox, withEmailBtn, signInBtn) = createRefs()


      Box(modifier = Modifier.constrainAs(appName) {
        linkTo(start = parent.start, end = parent.end)
        linkTo(top = parent.top, bottom = parent.bottom, bias = .05f)
      }) {
        AppName(titleColor = DarkPaleBlue, taglineColor = LightPaleBlue)
      }
      Text(
        text = stringResource(id = R.string.sign_up),
        fontFamily = PlaypenSans.regular,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        modifier = Modifier.constrainAs(signUpTxt) {
          linkTo(start = parent.start, end = parent.end)
          top.linkTo(appName.bottom, margin = 40.dp)
        })

      /**
       * Username
       **/
      TextInputLayout(modifier = Modifier
        .constrainAs(usernameTil) {
          linkTo(start = parent.start, end = parent.end)
          top.linkTo(signUpTxt.bottom, margin = 7.dp)
        }
        .fillMaxWidth()
        .padding(horizontal = 60.dp, vertical = 10.dp),
        textValue = username.value,
        changeTextValue = {
          username.value = it
        },
        labelString = stringResource(id = R.string.username_txt),
        iconId = R.drawable.ic_person)

      /**
       * Phone no
       **/
      TextInputLayout(modifier = Modifier
        .constrainAs(phoneNoTil) {
          linkTo(start = parent.start, end = parent.end)
          top.linkTo(usernameTil.bottom, margin = 7.dp)
        }
        .fillMaxWidth()
        .padding(horizontal = 60.dp, vertical = 10.dp),
        textValue = mobileNo.value,
        changeTextValue = {
          mobileNo.value = it
        },
        labelString = stringResource(id = R.string.phone_txt),
        iconId = R.drawable.ic_phone)

      /**
       * DOB
       **/
      TextInputLayout(modifier = Modifier
        .constrainAs(dobTil) {
          linkTo(start = parent.start, end = parent.end)
          top.linkTo(phoneNoTil.bottom, margin = 7.dp)
        }
        .fillMaxWidth()
        .padding(horizontal = 60.dp, vertical = 10.dp),
        textValue = dateOfBirth.value,
        changeTextValue = {
          dateOfBirth.value = it
        },
        labelString = stringResource(id = R.string.dob_txt),
        iconId = R.drawable.ic_cake)

      /**
       * Occupation
       **/
      TextInputLayout(modifier = Modifier
        .constrainAs(occupationTil) {
          linkTo(start = parent.start, end = parent.end)
          top.linkTo(dobTil.bottom, margin = 7.dp)
        }
        .fillMaxWidth()
        .padding(horizontal = 60.dp, vertical = 10.dp),
        textValue = occupation.value,
        changeTextValue = {
          occupation.value = it
        },
        labelString = stringResource(id = R.string.occupation_txt),
        iconId = R.drawable.ic_money)

      /**
       * Email
       **/
      TextInputLayout(modifier = Modifier
        .constrainAs(emailTil) {
          linkTo(start = parent.start, end = parent.end)
          top.linkTo(occupationTil.bottom, margin = 7.dp)
        }
        .fillMaxWidth()
        .padding(horizontal = 60.dp, vertical = 10.dp),
        textValue = email.value,
        changeTextValue = {
          email.value = it
        },
        labelString = stringResource(id = R.string.email_txt),
        iconId = R.drawable.ic_mail)

      /**
       * Password
       **/
      PasswordInputLayout(modifier = Modifier
        .constrainAs(passwordTil) {
          linkTo(start = parent.start, end = parent.end)
          top.linkTo(emailTil.bottom, margin = 7.dp)
        }
        .fillMaxWidth()
        .padding(horizontal = 60.dp, vertical = 10.dp),
        passwordValue = password.value,
        changePasswordValue = {
          password.value = it
        },
        labelString = stringResource(id = R.string.password), isLastField = false)

      /**
       * Confirm password
       **/
      PasswordInputLayout(modifier = Modifier
        .constrainAs(confirmPasswordTil) {
          linkTo(start = parent.start, end = parent.end)
          top.linkTo(passwordTil.bottom, margin = 7.dp)
        }
        .fillMaxWidth()
        .padding(horizontal = 60.dp, vertical = 10.dp),
        passwordValue = confirmPassword.value,
        changePasswordValue = {
          confirmPassword.value = it
        },
        labelString = stringResource(id = R.string.confirm_password), isLastField = true)
      val agreeToText = stringResource(id = R.string.agree_to)
      val tncText = stringResource(id = R.string.terms_and_conditions_txt)

      /**
       * TnC checkbox
       **/
      val checkboxString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Gray)) {
          pushStringAnnotation(tag = agreeToText, annotation = agreeToText)
          append(agreeToText)
        }
        withStyle(style = SpanStyle(color = LightBlue)) {
          pushStringAnnotation(tag = tncText, annotation = tncText)
          append(tncText)
        }
      }

      CheckboxComponent(value = checkboxString, modifier = Modifier.constrainAs(tNcCheckbox) {
        linkTo(start = parent.start, end = parent.end)
        top.linkTo(confirmPasswordTil.bottom, margin = 20.dp)
      },
        checkboxState = tncCheck.value,
        changeCheckboxState = {
          tncCheck.value = !tncCheck.value
        })

      /**
       * Signup button
       **/
      Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 60.dp, vertical = 10.dp)
          .constrainAs(withEmailBtn) {
            linkTo(start = parent.start, end = parent.end)
            top.linkTo(tNcCheckbox.bottom, margin = 10.dp)
          },
        elevation = ButtonDefaults.buttonElevation(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = LightBlue)
      ) {
        Text(
          text = stringResource(R.string.create_account),
          fontFamily = PlaypenSans.regular,
          fontWeight = FontWeight.Bold,
          color = Color.White
        )
      }

      /**
       * Sign in button
       **/
      val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Gray)) {
          append(stringResource(id = R.string.already_have_an_account))
        }
        withStyle(style = SpanStyle(color = LightBlue)) {
          append(stringResource(id = R.string.sign_in))
        }
      }
      TextButton(onClick = { navigateToLoginScreen() }, modifier = Modifier.constrainAs(signInBtn) {
        linkTo(
          top = withEmailBtn.bottom,
          bottom = parent.bottom,
          bottomMargin = 10.dp,
          bias = 1.0f,
          topMargin = 30.dp
        )
        start.linkTo(parent.start)
        end.linkTo(parent.end)
      }) {
        Text(text = annotatedString, fontFamily = PlaypenSans.regular)
      }
    }
  }
}

@Preview
@Composable
fun PreviewSignUpScreen() {
  SignupScreen({})
}