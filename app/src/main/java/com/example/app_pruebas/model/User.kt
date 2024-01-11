package com.example.app_pruebas.model
import java.io.Serializable

data class User(
    val name: String = "",
    val password: String = ""
) : Serializable
