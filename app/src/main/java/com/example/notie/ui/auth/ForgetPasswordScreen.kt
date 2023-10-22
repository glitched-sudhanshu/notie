package com.example.notie.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.notie.R
import com.example.notie.ui.components.TextInputLayout
import com.example.notie.ui.theme.BackgroundGrey
import com.example.notie.ui.theme.LightBlue
import com.example.notie.ui.theme.PlaypenSans

@Composable
fun ForgetPasswordScreen() {
  ConstraintLayout(
    modifier = Modifier
      .fillMaxSize()
      .background(color = BackgroundGrey)
      .padding(horizontal = 35.dp)
      .padding(top = 30.dp, bottom = 10.dp)
  ) {
    val (resetPwTitle, resetPwDesc, emailTil, resetPwBtn) = createRefs()

    Text(
      modifier = Modifier.constrainAs(resetPwTitle) {
        linkTo(start = parent.start, end = parent.end, bias = 0f)
        linkTo(top = parent.top, bottom = parent.bottom, bias = 0f)
      },
      text = stringResource(id = R.string.reset_password),
      fontFamily = PlaypenSans.regular,
      fontWeight = FontWeight.Bold,
      fontSize = 30.sp
    )

    Text(
      modifier = Modifier.constrainAs(resetPwDesc) {
        linkTo(start = parent.start, end = parent.end, bias = 0f)
        top.linkTo(resetPwTitle.bottom, margin = 15.dp)
      }, fontFamily = PlaypenSans.regular, color = Color.Gray, fontSize = 16.sp , text = stringResource(id = R.string.reset_password_description_text))

    TextInputLayout(
      modifier = Modifier.constrainAs(emailTil) {
        linkTo(start = parent.start, end = parent.end, bias = 0f)
        top.linkTo(resetPwDesc.bottom, margin = 25.dp)
      },
      isLastField = true,
      labelString = stringResource(id = R.string.email_txt),
      iconId = R.drawable.ic_mail
    )

    Button(
      onClick = { /*TODO*/ },
      modifier = Modifier
        .fillMaxWidth()
        .constrainAs(resetPwBtn) {
          linkTo(start = parent.start, end = parent.end, bias = 0f)
          bottom.linkTo(parent.bottom, margin = 10.dp)
        },
      elevation = ButtonDefaults.buttonElevation(8.dp),
      colors = ButtonDefaults.buttonColors(containerColor = LightBlue)
    ) {
      androidx.compose.material.Text(
        text = stringResource(R.string.request_password_reset),
        fontFamily = PlaypenSans.regular,
        fontWeight = FontWeight.Bold,
        color = Color.White
      )
    }
  }
}

@Preview
@Composable
fun PreviewForgetPasswordScreen()
{
  ForgetPasswordScreen()
}