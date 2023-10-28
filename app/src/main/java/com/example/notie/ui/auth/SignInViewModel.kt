package com.example.notie.ui.auth

import androidx.lifecycle.ViewModel
import com.example.notie.ui.auth.SignInResult
import com.example.notie.ui.auth.SignInState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignInViewModel : ViewModel() {

  private val _signInState = MutableStateFlow<SignInState>(SignInState.Initialized)
  val signInState = _signInState.asStateFlow()

  fun onSignInResult(result: SignInResult) {
    if(result.data!=null)
    {
      _signInState.value = SignInState.Success(result.data)
    }
    else _signInState.value = SignInState.Error(result.errorMessage)
  }

  fun resetState() {
    _signInState.value = SignInState.Initialized
  }
}