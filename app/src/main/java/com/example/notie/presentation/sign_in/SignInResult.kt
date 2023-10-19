package com.example.notie.presentation.sign_in

import com.example.notie.data.models.User

data class SignInResult(
  val data: User?,
  val errorMessage: String?,
)