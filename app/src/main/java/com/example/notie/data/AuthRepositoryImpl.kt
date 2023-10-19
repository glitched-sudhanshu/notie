package com.example.notie.data

import com.example.notie.data.models.User
import com.example.notie.utils.ResourceV2
import com.example.notie.utils.await
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(
  private val firebaseAuth: FirebaseAuth
) : AuthRepository {

  override val currentUser: FirebaseUser?
    get() = firebaseAuth.currentUser

  override suspend fun login(email: String, password: String): ResourceV2<FirebaseUser> {
    TODO("Not yet implemented")
  }

  override suspend fun login(user: User): ResourceV2<FirebaseUser> {
    return try {
      val result =
        firebaseAuth.signInWithEmailAndPassword(user.email.toString(), user.password.toString())
          .await()
      ResourceV2.Success(result.user!!)
    } catch (e: Exception) {
      e.printStackTrace()
      ResourceV2.Error(e.message)
    }
  }

  override suspend fun signup(
    name: String,
    email: String,
    password: String
  ): ResourceV2<FirebaseUser> {
    TODO("Not yet implemented")
  }

  override suspend fun signup(user: User): ResourceV2<FirebaseUser> {
    return try {
      val result =
        firebaseAuth.createUserWithEmailAndPassword(user.email.toString(), user.password.toString())
          .await()
      result.user?.updateProfile(
        UserProfileChangeRequest.Builder().setDisplayName(user.userName).build()
      )?.await()
      ResourceV2.Success(result.user!!)
    } catch (e: Exception) {
      e.printStackTrace()
      ResourceV2.Error(e.message)
    }
  }

  override fun logout() {
    firebaseAuth.signOut()
  }
}