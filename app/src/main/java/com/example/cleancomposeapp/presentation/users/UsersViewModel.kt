package com.example.cleancomposeapp.presentation.users
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleancomposeapp.domain.usecase.ObserveUsersUseCase
import com.example.cleancomposeapp.domain.usecase.RefreshUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val observeUsers: ObserveUsersUseCase,
    private val refreshUsers: RefreshUsersUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(UsersState(isLoading = true))
    val state: StateFlow<UsersState> = _state

    init {
        viewModelScope.launch {
            observeUsers().collectLatest { users ->
                _state.value = _state.value.copy(
                    users = users.map { UserUi(it.id, it.name, it.email) },
                    isLoading = false,
                    error = null
                )
            }
        }
        dispatch(UsersIntent.Refresh)
    }

    fun dispatch(intent: UsersIntent) {
        when (intent) {
            UsersIntent.Refresh -> refresh()
            is UsersIntent.OpenDetail -> {  }
        }
    }

    private fun refresh() = viewModelScope.launch {
        _state.value = _state.value.copy(isLoading = true, error = null)
        val r = refreshUsers()
        _state.value = _state.value.copy(isLoading = false, error = r.exceptionOrNull()?.message)
    }
}
