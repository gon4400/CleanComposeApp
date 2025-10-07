package com.example.cleancomposeapp.data.remote

data class RemoteUserDto(
    val id: Long,
    val name: String,
    val email: String,
    val company: CompanyDto?
) { data class CompanyDto(val name: String?) }
