package com.example.myapplication

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()
    data class Sucess<T>(val data: T) : UiState<T>()
    data class Error(val message: String) : UiState<Nothing>()
}