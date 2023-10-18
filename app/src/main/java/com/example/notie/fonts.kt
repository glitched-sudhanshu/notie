package com.example.notie


import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont

private object FontFamilyProvider{
  val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
  )
}

object AudioWideFont{
  private val fontName = GoogleFont("Audiowide")

  val fontFamily = FontFamily(
    Font(googleFont = fontName, fontProvider = FontFamilyProvider.provider)
  )
}