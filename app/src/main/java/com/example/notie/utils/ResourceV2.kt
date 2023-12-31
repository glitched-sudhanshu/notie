package com.example.notie.utils

sealed class ResourceV2<out T> {

  data class Initialized<out T>(val data: T? = null) : ResourceV2<T>()
  data class Loading<out T>(val data: T? = null) : ResourceV2<T>()
  data class Success<out T>(val data: T) : ResourceV2<T>()
  data class Error<out T>(val message: String?) : ResourceV2<T>()

  fun isLoading(): Boolean {
    return this is Loading
  }

  fun isSuccess(): Boolean {
    return this is Success
  }

  fun isError(): Boolean {
    return this is Error
  }
}