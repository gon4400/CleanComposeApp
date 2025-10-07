package com.example.cleancomposeapp.domain.repository
import com.example.cleancomposeapp.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun observeUsers(): Flow<List<User>>
    suspend fun refresh(): Result<Unit>
    suspend fun getUser(id: Long): Result<User>
}
