package com.example.notie.presentation.sign_in

import androidx.lifecycle.ViewModel
import androidx.room.util.copy
import com.example.notie.utils.ResourceV2
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignInViewModel : ViewModel() {

  private val _signInState = MutableStateFlow<ResourceV2<Boolean>>(ResourceV2.Initialized(null))
  val signInState = _signInState.asStateFlow()

  fun onSignInResult(result: SignInResult)
  {
    _signInState.update {
      when(it)
      {
        is ResourceV2.Initialized -> it.copy(null)
        is ResourceV2.Loading -> it.copy(null)
        is ResourceV2.Success -> it.copy(data = result.data != null)
        is ResourceV2.Error -> it.copy(message = result.errorMessage)
      }
    }
  }

  fun resetState(){
    _signInState.update {
      when(it)
    {
      is ResourceV2.Initialized -> it.copy(null)
      is ResourceV2.Loading -> it.copy(null)
      is ResourceV2.Success -> it.copy(false)
      is ResourceV2.Error -> it.copy(message = null)
    } }
  }

}