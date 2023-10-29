package com.example.notie.ui.notes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAlert
import androidx.compose.material.icons.filled.NoteAdd
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.notie.R
import com.example.notie.ui.components.TypeCard
import com.example.notie.ui.components.shadow
import com.example.notie.ui.theme.BackgroundGrey
import com.example.notie.ui.theme.DarkPaleBlue
import com.example.notie.ui.theme.Grey
import com.example.notie.ui.theme.LightBlue
import com.example.notie.ui.theme.LightPaleBlue
import com.example.notie.ui.theme.PlaypenSans

@Composable
fun HomeScreen() {
  ConstraintLayout(
    modifier = Modifier
      .fillMaxSize()
      .background(color = BackgroundGrey)
      .padding(15.dp)
  )
  {
    val (ivProfilePic, tvUsername, allNotesBox, impNoteBox, todoNoteBox) = createRefs()


    Image(
      modifier = Modifier
        .size(48.dp)
        .clip(CircleShape)
        .background(color = Grey)
        .padding(4.dp)
        .border(width = 1.dp, color = Grey, shape = CircleShape)
        .constrainAs(ivProfilePic) {
          linkTo(start = parent.start, end = parent.end, bias = 0f)
          linkTo(top = parent.top, bottom = parent.bottom, bias = 0f)
        },
      painter = painterResource(id = R.drawable.ic_person),
      contentDescription = stringResource(id = R.string.profile_picture)
    )

    Text(
      text = "Sudhanshu Ranjan", modifier = Modifier.constrainAs(tvUsername) {
        linkTo(top = ivProfilePic.top, bottom = ivProfilePic.bottom)
        linkTo(start = ivProfilePic.end, end = parent.end, bias = 0f, startMargin = 12.dp)
      },
      fontSize = 20.sp, fontFamily = PlaypenSans.regular, fontWeight = FontWeight.Bold
    )
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp - 30.dp - 10.dp
    val screenHeight = (screenWidth * 3) / 4
    val typeCardShadow = Modifier.shadow(
      color = DarkPaleBlue,
      offsetX = 20.dp,
      offsetY = 20.dp,
      spread = 2.dp,
      borderRadius = 20.dp,
      blurRadius = 10.dp,
    )

    TypeCard(
      modifier = typeCardShadow
        .constrainAs(allNotesBox) {
          linkTo(start = parent.start, end = parent.end, bias = 0f)
          top.linkTo(ivProfilePic.bottom, margin = 25.dp)
        },
      height = screenHeight,
      width = screenWidth / 2,
      cardTitle = "Notes",
      cardSubTitle = "116",
      cardTitleColor = Color.White,
      cardSubTitleColor = Color.White,
      backgroundColor = LightBlue,
      isFabEnabled = true,
      iconTint = Color.White,
      cardIcon = Icons.Filled.NoteAdd
    )

    TypeCard(
      modifier = typeCardShadow
        .constrainAs(todoNoteBox) {
          linkTo(start = parent.start, end = parent.end, bias = 1f)
          top.linkTo(ivProfilePic.bottom, margin = 25.dp)
        }, height = screenHeight / 2,
      width = screenWidth / 2,
      cardTitle = "To-do",
      cardSubTitle = "34",
      cardTitleColor = DarkPaleBlue,
      cardSubTitleColor = Color.Black,
      backgroundColor = Grey,
      isFabEnabled = false,
      iconTint = LightPaleBlue,
      cardIcon = Icons.Filled.AddAlert
    )


    TypeCard(
      modifier = typeCardShadow
        .constrainAs(impNoteBox) {
          linkTo(start = parent.start, end = parent.end, bias = 1f)
          top.linkTo(todoNoteBox.bottom, margin = 10.dp)
        }, height = ((screenHeight / 2) - 10.dp),
      width = screenWidth / 2,
      cardTitle = "Important",
      cardSubTitle = "16",
      cardTitleColor = DarkPaleBlue,
      cardSubTitleColor = Color.Black,
      backgroundColor = Grey,
      isFabEnabled = false,
      iconTint = LightPaleBlue,
      cardIcon = Icons.Filled.Star

      
    )
  }
}

@Preview
@Composable
fun PreviewHomeScreen() {
  HomeScreen()
}