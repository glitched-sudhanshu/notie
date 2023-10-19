package com.example.notie.data

import com.example.notie.data.models.User
import com.example.notie.utils.ResourceV2
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {

  val currentUser: FirebaseUser?

  suspend fun login(email: String, password: String): ResourceV2<FirebaseUser>

  suspend fun login(user: User): ResourceV2<FirebaseUser>

  suspend fun signup(name: String, email: String, password: String): ResourceV2<FirebaseUser>

  suspend fun signup(user: User): ResourceV2<FirebaseUser>

  fun logout()
}