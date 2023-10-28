package com.example.notie.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notie.data.AuthRepository
import com.example.notie.data.models.Occupation
import com.example.notie.data.models.User
import com.example.notie.utils.ResourceV2
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val repository: AuthRepository) : ViewModel() {

  private val _loginFlow = MutableStateFlow<ResourceV2<FirebaseUser>?>(null)
  val loginFlow: StateFlow<ResourceV2<FirebaseUser>?> = _loginFlow

  private val _signupFlow = MutableStateFlow<ResourceV2<FirebaseUser>?>(null)
  val signupFlow: StateFlow<ResourceV2<FirebaseUser>?> = _signupFlow

  val currentUser: FirebaseUser?
    get() = repository.currentUser

  init {
    if(repository.currentUser != null){
      _loginFlow.value = ResourceV2.Success(repository.currentUser!!)
    }
  }

  fun createAccount(username: String, mobileNo : String, dateOfBirth : String, occupation: String, email: String, password: String)
  {
    val user = User(
      userName = username,
      phoneNumber = mobileNo,
      email = email,
      password = password
    )
  }

  fun login(user: User) = viewModelScope.launch {
    _loginFlow.value = ResourceV2.Loading()
    val result = repository.login(user)
    _loginFlow.value = result
  }

  fun signup(user: User) = viewModelScope.launch {
    _signupFlow.value = ResourceV2.Loading()
    val result = repository.signup(user)
    _signupFlow.value = result
  }

  fun logout(){
    repository.logout()
    _signupFlow.value = null
    _loginFlow.value = null
  }

}