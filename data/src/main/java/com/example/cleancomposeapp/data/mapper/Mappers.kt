package com.example.cleancomposeapp.data.mapper
import com.example.cleancomposeapp.data.local.UserEntity
import com.example.cleancomposeapp.data.remote.RemoteUserDto
import com.example.cleancomposeapp.domain.model.User

fun RemoteUserDto.toEntity() = UserEntity(
    id = id, name = name, email = email, company = company?.name
)

fun UserEntity.toDomain() = User(
    id = id, name = name, email = email, company = company
)
