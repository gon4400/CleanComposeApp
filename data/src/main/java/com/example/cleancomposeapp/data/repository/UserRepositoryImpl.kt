package com.example.cleancomposeapp.data.repository
import com.example.cleancomposeapp.data.local.UserDao
import com.example.cleancomposeapp.data.mapper.toDomain
import com.example.cleancomposeapp.data.mapper.toEntity
import com.example.cleancomposeapp.data.remote.UserApi
import com.example.cleancomposeapp.domain.model.User
import com.example.cleancomposeapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(
    private val api: UserApi,
    private val dao: UserDao
) : UserRepository {

    override fun observeUsers(): Flow<List<User>> =
        dao.observeAll().map { list -> list.map { it.toDomain() } }

    override suspend fun refresh(): Result<Unit> = runCatching {
        val remote = api.getUsers()
        dao.upsertAll(remote.map { it.toEntity() })
    }

    override suspend fun getUser(id: Long): Result<User> = runCatching {
        dao.getById(id)?.toDomain() ?: error("Not found")
    }
}
