package com.example.notie.ui.components

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddAlert
import androidx.compose.material.icons.filled.NoteAdd
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.notie.R
import com.example.notie.ui.theme.AudioWideFont
import com.example.notie.ui.theme.BackgroundGrey
import com.example.notie.ui.theme.LightBlue
import com.example.notie.ui.theme.LightPaleBlue
import com.example.notie.ui.theme.PlaypenSans

@Composable
fun AppName(
  titleSize: TextUnit = 45.sp,
  taglineSize: TextUnit = 12.sp,
  titleColor: Color = Color.White,
  taglineColor: Color = Color.White
) {
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
fun PreviewAppName() {
  AppName()
}

@Composable
fun TypeCard(
  modifier: Modifier = Modifier,
  height: Dp,
  width: Dp,
  cardTitle: String,
  cardSubTitle: String,
  backgroundColor: Color = LightBlue,
  cardTitleColor: Color = Color.White,
  cardSubTitleColor: Color = Color.White,
  isFabEnabled: Boolean = true,
  cardIcon: ImageVector = Icons.Filled.Add,
  iconTint: Color = Color.White
) {
  Box(
    modifier = modifier
      .height(height)
      .width(width)
      .clip(shape = RoundedCornerShape(20.dp))
      .background(color = backgroundColor)
  ) {
    Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.SpaceBetween
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top) {
        Text(
          text = cardTitle,
          fontFamily = AudioWideFont.fontFamily,
          fontSize = 26.sp,
          modifier = Modifier.padding(top = 15.dp, start = 15.dp),
          color = cardTitleColor
        )
        Icon(
          imageVector = cardIcon,
          modifier = Modifier
            .padding(top = 15.dp, end = 15.dp)
            .size(32.dp),
          contentDescription = stringResource(id = R.string.add_new_note),
          tint = iconTint
        )
      }
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
      ) {
        Text(
          text = cardSubTitle,
          fontFamily = PlaypenSans.regular,
          fontSize = 26.sp,
          modifier = Modifier.padding(bottom = 15.dp, start = 15.dp),
          color = cardSubTitleColor,
          fontWeight = FontWeight.Bold
        )
        var expandableFabState by remember { mutableStateOf(false) }
        if (isFabEnabled) ExpandableFab(
          fabStateOpen = expandableFabState,
          onFabStateChange = {
            expandableFabState = it
          },
          modifier = Modifier.padding(bottom = 15.dp, end = 15.dp),
        )
      }
    }
  }
}

@Preview
@Composable
fun PreviewTypeCard() {
  TypeCard(height = 160.dp, width = 110.dp, cardTitle = "Note", cardSubTitle = "116")
}

@Composable
fun ExpandableFab(
  fabStateOpen: Boolean = false,
  onFabStateChange: (Boolean) -> Unit,
  modifier: Modifier = Modifier
) {
  val transition = updateTransition(targetState = fabStateOpen, label = "fab transition")
  val rotate by transition.animateFloat(label = "fab rotate") {
    if (it) 315f else 0f
  }

  val fabScale by transition.animateFloat(label = "fab scale transition") {
    if(it) 1f else 0f
  }

  val fabAlpha by transition.animateFloat(label = "fab aplha transition", transitionSpec = { tween(durationMillis = 50) }) {
    if(it) 1f else 0f

  }
  val fabShadow by transition.animateDp(label = "fab shadow transition", transitionSpec = { tween(durationMillis = 50) }) {
    if(it) 2.dp else 0.dp

  }

  ConstraintLayout(
    modifier = modifier
      .wrapContentHeight()
      .wrapContentWidth()
      .padding(10.dp),
  ) {
    val (mainBtn, bottomBtn, cornerBtn, topBtn) = createRefs()


    FloatingActionButton(
      onClick = {
        onFabStateChange(!transition.currentState)
      },
      backgroundColor = BackgroundGrey,
      modifier = Modifier.constrainAs(mainBtn) {
        linkTo(start = parent.start, end = parent.end, bias = 1f)
        linkTo(top = parent.top, bottom = parent.bottom, bias = 1f)
      }
    ) {
      Icon(
        imageVector = Icons.Filled.Add,
        stringResource(id = R.string.add_new_note),
        tint = LightPaleBlue, modifier = Modifier.rotate(rotate)
      )
    }

    if(fabStateOpen)SmallFloatingActionButton(
      onClick = { /*TODO*/ },
      containerColor = LightPaleBlue,
      shape = CircleShape,
      modifier = Modifier
        .constrainAs(bottomBtn) {
          linkTo(start = parent.start, end = mainBtn.start, bias = 0f, endMargin = 15.dp)
          linkTo(top = parent.top, bottom = parent.bottom, bias = 1f)
        }
        .alpha(fabAlpha)
        .scale(fabScale)
    ) {
      Icon(
        imageVector = Icons.Filled.Star,
        stringResource(id = R.string.add_new_note),
        tint = BackgroundGrey
      )
    }

    if(fabStateOpen)SmallFloatingActionButton(
      onClick = { /*TODO*/ },
      containerColor = LightPaleBlue,
      shape = CircleShape,
      modifier = Modifier
        .constrainAs(cornerBtn) {
          linkTo(start = parent.start, end = mainBtn.start, bias = 1f)
          linkTo(top = parent.top, bottom = mainBtn.top, bias = 1f)
        }
        .alpha(fabAlpha)
        .scale(fabScale)
    ) {
      Icon(
        imageVector = Icons.Filled.NoteAdd,
        stringResource(id = R.string.add_new_note),
        tint = BackgroundGrey
      )
    }

    if(fabStateOpen)SmallFloatingActionButton(
      onClick = { /*TODO*/ },
      containerColor = LightPaleBlue,
      shape = CircleShape,
      modifier = Modifier
        .constrainAs(topBtn) {
          linkTo(start = parent.start, end = parent.end, bias = 1f)
          linkTo(top = parent.top, bottom = mainBtn.top, bias = 1f, bottomMargin = 10.dp)
        }
        .alpha(fabAlpha)
        .scale(fabScale)
    ) {
      Icon(
        imageVector = Icons.Filled.AddAlert,
        stringResource(id = R.string.add_new_note),
        tint = BackgroundGrey
      )
    }
  }

}

@Composable
@Preview
fun PreviewExpandableFab() {
  ExpandableFab(fabStateOpen = true, onFabStateChange = {})
}