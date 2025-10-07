package com.example.cleancomposeapp.domain.usecase
import com.example.cleancomposeapp.domain.repository.UserRepository

class RefreshUsersUseCase(private val repo: UserRepository) {
    suspend operator fun invoke(): Result<Unit> = repo.refresh()
}
