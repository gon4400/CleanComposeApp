package com.example.cleancomposeapp.domain.usecase
import com.example.cleancomposeapp.domain.model.User
import com.example.cleancomposeapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class ObserveUsersUseCase(private val repo: UserRepository) {
    operator fun invoke(): Flow<List<User>> = repo.observeUsers()
}
