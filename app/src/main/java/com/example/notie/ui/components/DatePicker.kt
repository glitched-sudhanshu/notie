package com.example.notie.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.example.notie.R
import com.example.notie.ui.theme.DarkPaleBlue
import com.example.notie.ui.theme.FacebookBlue
import com.example.notie.ui.theme.PlaypenSans
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.DatePickerDefaults
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun DatePickerView(modifier: Modifier = Modifier, @DrawableRes iconId: Int = -1) {
  var pickedDate by remember {
    mutableStateOf(LocalDate.now())
  }
  val formattedDate by remember {
    derivedStateOf {
      DateTimeFormatter
        .ofPattern("dd MM yyyy")
        .format(pickedDate)
    }
  }
  val dateDialogState = rememberMaterialDialogState()

  Column(
    modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    Button(
      onClick = { dateDialogState.show() }, modifier = Modifier.fillMaxWidth(),
      colors = ButtonDefaults.buttonColors(containerColor = Color.White)
    ) {
      Icon(
        painter = painterResource(id = iconId),
        contentDescription = stringResource(
          id = R.string.pick_date
        ),
        tint = Color.Unspecified,
        modifier = Modifier
          .size(24.dp)
          .offset(x = (-14).dp)
      )
      Text(
        text = stringResource(id = R.string.pick_date),
        fontFamily = PlaypenSans.regular,
        color = DarkPaleBlue
      )
      Text(text = formattedDate)
    }
  }

  MaterialDialog(
    dialogState = dateDialogState,
    properties = DialogProperties(
      dismissOnBackPress = true,
      dismissOnClickOutside = true
    ),
    buttons = {
      positiveButton(
        text = stringResource(id = R.string.ok),
        textStyle = TextStyle(fontFamily = PlaypenSans.regular)
      )
      negativeButton(
        text = stringResource(id = R.string.cancel),
        textStyle = TextStyle(fontFamily = PlaypenSans.regular)
      )
    }
  ) {
    this.datepicker(
      initialDate = LocalDate.now(),
      title = stringResource(id = R.string.pick_date),
      colors = DatePickerDefaults.colors(
      ),
      allowedDateValidator = {
        it <= LocalDate.now()
      }
    ) {
      pickedDate = it
    }
  }
}

