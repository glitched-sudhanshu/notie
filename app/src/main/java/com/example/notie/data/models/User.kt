package com.example.notie.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notie.utils.Constants.USER_DATABASE_TABLE
import java.time.LocalDateTime

@Entity(tableName = USER_DATABASE_TABLE)
data class User(
  @PrimaryKey(autoGenerate = true)
  val id: String = "",
  val userName: String,
  val displayPicture: String? = null,
  val password: String? = null,
  val phoneNumber: String? = null,
  val email: String? = null,
  val age: Int? = null,
  val dateOfBirth: LocalDateTime? = null,
  val occupation: Occupation? = null
  )