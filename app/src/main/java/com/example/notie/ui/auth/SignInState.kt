package com.example.notie.ui.auth

import com.example.notie.data.models.User

sealed class SignInState{

  object Initialized: SignInState()

  object Loading: SignInState()

  data class Success(val user: User?) : SignInState() {

    override fun equals(other: Any?): Boolean {
      return if (other is Success) other.user?.email == this.user?.email
      else false
    }
  }

  data class Error(val message : String?) : SignInState()

}

data class SignInResult(
  val data: User?,
  val errorMessage: String?,
)