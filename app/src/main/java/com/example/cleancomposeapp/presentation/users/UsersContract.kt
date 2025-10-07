package com.example.cleancomposeapp.presentation.users

data class UserUi(val id: Long, val title: String, val subtitle: String)

data class UsersState(
    val isLoading: Boolean = false,
    val users: List<UserUi> = emptyList(),
    val error: String? = null
)

sealed interface UsersIntent {
    data object Refresh : UsersIntent
    data class OpenDetail(val id: Long) : UsersIntent
}
