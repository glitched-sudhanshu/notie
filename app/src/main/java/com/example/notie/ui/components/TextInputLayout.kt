package com.example.notie.ui.components

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material3.CheckboxColors
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notie.R
import com.example.notie.ui.theme.AudioWideFont
import com.example.notie.ui.theme.DarkPaleBlue
import com.example.notie.ui.theme.LightPaleBlue
import com.example.notie.ui.theme.PlaypenSans

@Composable
fun TextInputLayout(
  modifier: Modifier = Modifier,
  labelString: String,
  @DrawableRes iconId: Int = 0,
  isLastField: Boolean = false
) {

  val localFocusManager = LocalFocusManager.current
  
  val textValue = remember {
    mutableStateOf("")
  }

  OutlinedTextField(
    label = {
      Text(
        text = labelString,
        fontFamily = PlaypenSans.regular
      )
    },
    textStyle = TextStyle(
      fontFamily = PlaypenSans.regular
    ),
    modifier = modifier
      .fillMaxWidth(),
    shape = RoundedCornerShape(50),
    colors = TextFieldDefaults.outlinedTextFieldColors(
      focusedBorderColor = Color.Transparent,
      unfocusedBorderColor = Color.Transparent,
      focusedLabelColor = DarkPaleBlue,
      unfocusedLabelColor = DarkPaleBlue,
      backgroundColor = Color.White
    ),
    singleLine = true,
    maxLines = 1,
    keyboardOptions = if (!isLastField) KeyboardOptions(imeAction = ImeAction.Next) else KeyboardOptions(
      imeAction = ImeAction.Done
    ),
    keyboardActions = KeyboardActions {
      if (isLastField) localFocusManager.clearFocus()
    },
    value = textValue.value, onValueChange = {
      textValue.value = it
    },
    leadingIcon = {
      if (iconId != 0) Icon(
        painter = painterResource(id = iconId), contentDescription = labelString,
        tint = Color.Unspecified,
        modifier = Modifier
          .size(24.dp)
      )
    })
}

@Composable
fun PasswordInputLayout(modifier: Modifier = Modifier, labelString: String, isLastField: Boolean) {
  val localFocusManager = LocalFocusManager.current
  val passwordText = remember {
    mutableStateOf("")
  }
  val passwordVisibility = remember {
    mutableStateOf(false)
  }


  OutlinedTextField(
    label = {
      Text(
        text = labelString,
        fontFamily = PlaypenSans.regular
      )
    },
    value = passwordText.value,
    modifier = modifier
      .fillMaxWidth(),
    shape = RoundedCornerShape(50),
    colors = TextFieldDefaults.outlinedTextFieldColors(
      focusedBorderColor = Color.Transparent,
      unfocusedBorderColor = Color.Transparent,
      focusedLabelColor = DarkPaleBlue,
      unfocusedLabelColor = DarkPaleBlue,
      backgroundColor = Color.White
    ),
    singleLine = true,
    maxLines = 1,
    keyboardOptions = if (!isLastField) KeyboardOptions(
      imeAction = ImeAction.Next,
      keyboardType = KeyboardType.Password
    ) else KeyboardOptions(imeAction = ImeAction.Done, keyboardType = KeyboardType.Password),
    keyboardActions = KeyboardActions {
      if (isLastField) localFocusManager.clearFocus()
    },
    onValueChange = {
      passwordText.value = it
    },
    leadingIcon = {
      Icon(
        painter = painterResource(id = R.drawable.ic_lock), contentDescription = labelString,
        tint = Color.Unspecified,
        modifier = Modifier
          .size(24.dp)
      )
    },
    trailingIcon = {
      val icon = if (passwordVisibility.value) {
        Icons.Filled.Visibility
      } else Icons.Filled.VisibilityOff
      val description = if (passwordVisibility.value) {
        stringResource(id = R.string.hide_password)
      } else stringResource(id = R.string.show_password)

      IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value }) {
        Icon(imageVector = icon, contentDescription = description, tint = DarkPaleBlue)
      }
    },
    visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation()
  )

}

@Composable
fun CheckboxComponent(value: AnnotatedString, modifier: Modifier = Modifier) {
  Row(
    modifier = modifier
      .heightIn(56.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    val checkboxState = remember {
      mutableStateOf(false)
    }

    Checkbox(
      checked = checkboxState.value, onCheckedChange = {
        checkboxState.value = !checkboxState.value
      },
      colors = CheckboxDefaults.colors(
        checkedColor = Color.White,
        uncheckedColor = Color.White,
        checkmarkColor = LightPaleBlue
      )
    )
    val context = LocalContext.current
    ClickableText(
      text = value,
      style = TextStyle(fontFamily = AudioWideFont.fontFamily, fontSize = 14.sp),
      onClick = { offset ->
        value.getStringAnnotations(offset, offset).firstOrNull()?.also { span ->
          if (span.item == "Terms & Conditions") {
            Toast.makeText(context, "Terms & Conditions shown!", Toast.LENGTH_SHORT).show()
          }
        }
      },
    )
  }
}

@Preview
@Composable
fun TextInputLayoutPreview() {
  TextInputLayout(Modifier, "first name", R.drawable.ic_person)
}

@Preview
@Composable
fun PasswordInputLayoutPreview() {
  PasswordInputLayout(Modifier, "password", false)
}