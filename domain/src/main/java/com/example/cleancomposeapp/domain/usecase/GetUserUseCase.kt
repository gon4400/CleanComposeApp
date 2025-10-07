package com.example.cleancomposeapp.domain.usecase
import com.example.cleancomposeapp.domain.model.User
import com.example.cleancomposeapp.domain.repository.UserRepository

class GetUserUseCase(private val repo: UserRepository) {
    suspend operator fun invoke(id: Long): Result<User> = repo.getUser(id)
}
